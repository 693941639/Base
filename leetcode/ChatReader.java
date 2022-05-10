package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChatReader implements Runnable {
    private BufferedReader reader;

    public ChatReader(InputStream is) {
        this.reader = new BufferedReader(new InputStreamReader(is));
    }

    @Override
    public void run() {
        String info;
        while (true) {
            try {
                info = this.reader.readLine();
                if (info.trim().contains("exit"))  {
                    break;
                } else {
                    System.out.println(info);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
