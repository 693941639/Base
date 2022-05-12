package Base.ChatRoom;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ChatWriter implements Runnable {
    private final Socket socket;

    public ChatWriter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
        ) {
            String a;
            while (true) {
                if (!(a = scanner.nextLine()).isEmpty()) {
                    writer.write(a);
                    writer.flush();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
