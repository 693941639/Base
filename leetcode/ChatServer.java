package leetcode;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        try (
            ServerSocket server = new ServerSocket(55535);
        ) {
            Socket socket = server.accept();
            ChatService cs = new ChatService(socket);
            cs.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
