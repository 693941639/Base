package leetcode;

import java.io.*;
import java.net.Socket;

public class ChatService {
    private Socket server;

    private InputStream is;
    private OutputStream os;

    public ChatService(Socket s) {
        try (
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
        ) {
            this.server = s;
            this.is = is;
            this.os = os;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        (new Thread(new ChatReader(this.is))).start();
        (new Thread(new ChatWriter(this.os))).start();
    }
}
