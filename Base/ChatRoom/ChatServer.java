package Base.ChatRoom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try (
            ServerSocket server = new ServerSocket(55556);
        ) {
            while (true) {
                Socket socket = server.accept();
                ChatService cs = new ChatService(socket);
                cs.run();
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
