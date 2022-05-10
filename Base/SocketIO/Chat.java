package Base.SocketIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Chat {
    private String from;
    private String greetings;
    private Socket socket;

    public static final String EXIT = "exit";

    public Chat(String from, String greetings, Socket socket) {
        this.from = from;
        this.greetings = greetings;
        this.socket = socket;
    }

    public void chatting() {
        Scanner in = new Scanner(System.in);

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        ) {
            if (greetings != null) {
                writer.println("你好，" + greetings);
                writer.flush();
            }

            while (true) {
                String info = reader.readLine();

                if (info.trim().contains(EXIT)) {
                    System.out.println("连接已断开");
                    writer.println("连接已断开");
                    writer.flush();
                    break;
                } else {
                    System.out.println(info);
                }

                info = in.nextLine();
                writer.println(from + ":" + info);
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
