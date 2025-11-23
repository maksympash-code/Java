package HW_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Connecting to " + HOST + ":" + PORT + "...");

        try (
                Socket socket = new Socket(HOST, PORT);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner console = new Scanner(System.in)
        ) {
            String serverMsg = in.readLine();
            if (serverMsg != null) {
                System.out.println("Server: " + serverMsg);
            }

            while (true) {
                System.out.print("Enter expression (or 'exit'): ");
                String line = console.nextLine();

                out.println(line);

                String response = in.readLine();
                if (response == null) {
                    System.out.println("Server closed connection.");
                    break;
                }

                System.out.println("Server response: " + response);

                if ("exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}

