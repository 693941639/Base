package Base.SocketIO;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 55556;
    public static void main(String[] args) {
        createServe();
    }

    public static void createServe() {
        System.out.println("服务建立成功");
        try (
            ServerSocket server = new ServerSocket(PORT);
            Socket s = server.accept();
        ) {
            Chat chat = new Chat("服务器", null, s);
            chat.chatting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
