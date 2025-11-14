package Practice_10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class A10_01_Server {
    public static void main(String[] args) throws IOException {
        int port = 11114;

        try(ServerSocket server = new ServerSocket(port)){
            System.out.println("Server is running up " + server.getLocalSocketAddress());

            while(true){
                Socket ccon = server.accept();
                System.out.println("Connection from " + ccon.getRemoteSocketAddress());

                var reader = new BufferedReader(
                        new InputStreamReader (
                            ccon.getInputStream(), StandardCharsets.UTF_8
                        )
                );

                var writer = new PrintWriter(
                        ccon.getOutputStream(), true, StandardCharsets.UTF_8
                );

                int i = 0;
                while(true){
                    String msg = reader.readLine();
                    System.out.println("Received: " + msg);
                    if (msg == null)
                        break;

                    msg = ++i + " " + msg;
                    writer.println(msg);
                    System.out.println("Sent: " + msg);
                }

                writer.println("Hello from Server");
                String msg = reader.readLine();
                System.out.println(msg);

                System.out.println("Disconnected " + ccon.getRemoteSocketAddress());
                ccon.close();
            }
        }
    }
}
