package leetcode;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    public static void main(String[] args) {
        try (
            Socket s = new Socket("localhost", 55535);
        ) {
            ChatService cs = new ChatService(s);
            cs.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
