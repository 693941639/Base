package Base.SocketIO;

import java.net.Socket;

import static Base.SocketIO.Server.PORT;

public class Client {
    public static void main(String[] args) {
        connectServer();
    }

    public static void connectServer() {
        try (
            Socket socket = new Socket("localhost", PORT);
        ) {
            Chat chat = new Chat("客户端", "你好服务器", socket);
            chat.chatting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
