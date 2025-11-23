package HW_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Server starting on port " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                out.println("Welcome to Server. Enter an expression for example '2 + 3' or 'exit'.");

                String line;
                while ((line = in.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(line.trim())) {
                        out.println("Bye!");
                        break;
                    }

                    String result = evaluateExpression(line);
                    out.println(result);
                }

            } catch (IOException e) {
                System.err.println("Client error: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException ignored) {
                }
                System.out.println("Client disconnected.");
            }
        }

        private String evaluateExpression(String expr) {
            String trimmed = expr.trim();

            Pattern pattern = Pattern.compile(
                    "^\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*([+\\-*/])\\s*([+-]?\\d+(?:\\.\\d+)?)\\s*$");
            Matcher matcher = pattern.matcher(trimmed);

            if (!matcher.matches()) {
                return "ERROR: invalid expression";
            }

            double a;
            double b;
            try {
                a = Double.parseDouble(matcher.group(1));
                b = Double.parseDouble(matcher.group(3));
            } catch (NumberFormatException e) {
                return "ERROR: cannot parse numbers";
            }

            char op = matcher.group(2).charAt(0);
            double res;

            switch (op) {
                case '+':
                    res = a + b;
                    break;
                case '-':
                    res = a - b;
                    break;
                case '*':
                    res = a * b;
                    break;
                case '/':
                    if (b == 0.0) {
                        return "ERROR: division by zero";
                    }
                    res = a / b;
                    break;
                default:
                    return "ERROR: unsupported operator";
            }

            return String.valueOf(res);
        }
    }
}

