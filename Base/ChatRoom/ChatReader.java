package Base.ChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;

public class ChatReader implements Runnable {
    private final Socket socket;

    public ChatReader(Socket socket) {
       this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        ) {
            String info;
            while (true) {
                info = reader.readLine();
                if (info != null) {
                    if (info.trim().contains("exit"))  {
                        break;
                    } else {
                        System.out.println(info);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
