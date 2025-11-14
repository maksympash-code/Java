package Practice_10;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class A10_01_Client {
    public static void main(String[] args) throws IOException {
        int port = 11114;
        String host = "localhost";

        String file_inp = "src/Practice_10/input.txt";
        String file_out = "src/Practice_10/output.txt";

        Socket socket = new Socket(host, port);
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        var reader = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8
                )
        );

        var writer = new PrintWriter(
                socket.getOutputStream(), true, StandardCharsets.UTF_8
        );

        var f_inp = new BufferedReader(new FileReader(file_inp, StandardCharsets.UTF_8));
        var f_out = new BufferedWriter(new FileWriter(file_out, StandardCharsets.UTF_8));

        while (true) {
            String msg = f_inp.readLine();
            writer.println(msg);
            System.out.println("Sent: " + msg);

            if (msg == null) {
                break;
            }

            msg = reader.readLine();
            System.out.println("Receive: " + msg);
            f_out.write(msg + "\n");
        }

        String msg = reader.readLine();
        System.out.println(msg);
        writer.println("Hello from Client");

        f_inp.close();
        f_out.close();

        System.out.println("Disconnected to " + socket.getRemoteSocketAddress());
        socket.close();
    }
}
