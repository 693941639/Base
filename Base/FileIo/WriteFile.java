package Base.FileIo;

import java.io.*;
import java.util.Scanner;

public class WriteFile {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        writeFile(createFile());
    }

    public static void writeFile(File file) {
        try (
            FileOutputStream fouts = new FileOutputStream(file);
            OutputStreamWriter outsw = new OutputStreamWriter(fouts);
            PrintWriter pw = new PrintWriter(outsw);
        ) {
            while (true) {
                String input = scanner.nextLine();

                if (input.isBlank()) {
                    break;
                }

                pw.println(input);
                pw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File createFile() {
        System.out.println("输入需要创建的文件:");

        String fileName = scanner.nextLine() + ".txt";

        File file = new File("." + File.separator + fileName);

        if (file.isFile()) {
            file.delete();
        }

        try {
            if (file.createNewFile()) {
                System.out.println("文件创建成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
