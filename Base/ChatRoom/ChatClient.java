package Base.ChatRoom;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        try (
            Socket s = new Socket("localhost", 55556);
        ) {
            ChatService cs = new ChatService(s);
            cs.run();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
