package Base.ChatRoom;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatService {
    private final Socket server;

    public ChatService(Socket s) {
        this.server = s;
    }

    public void run() throws IOException {
        try (
            Scanner scanner = new Scanner(System.in);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(this.server.getOutputStream()));
        ) {
            (new Thread(new ChatReader(this.server))).start();

            while (true) {
                String msg = scanner.nextLine();

                if (msg.trim().contains("exit")) {
                    break;
                }

                writer.println(msg);
                writer.flush();
            }
        } finally {
            this.server.close();
        }
    }
}
