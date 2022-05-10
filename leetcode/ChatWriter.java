package leetcode;

import java.io.*;
import java.util.Arrays;

public class ChatWriter implements Runnable {
    private BufferedWriter writer;

    private BufferedReader reader;

    public ChatWriter(OutputStream os) {
        this.writer = new BufferedWriter(new OutputStreamWriter(os));
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        String a;
        while (true) {
            try {
                if (!(a = this.reader.readLine()).isEmpty()) {
                    this.writer.write(a);
                    this.writer.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
