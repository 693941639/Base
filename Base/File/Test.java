package Base.File;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
    private static final String ROOT = "." + File.separator;
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        createFile(createFolder());
    }

    public static File createFolder() {
        scanner = new Scanner(System.in);
        ArrayList<String> folder = new ArrayList<>();

        while (true) {
            System.out.println("请输入文件夹的名称，如果为空则为确定");
            String str = scanner.nextLine();
            if (str.isBlank()) {
                break;
            }
            folder.add(str);
        }

        String path = Arrays.stream(folder.toArray(new String[0])).map(String::trim).collect(Collectors.joining(File.separator));

        File handle = new File(ROOT, path);

        handle.mkdirs();

        return handle;
    }

    public static File createFile(File handle) throws IOException {
        System.out.println("请输入需要创建的文件:");

        String name = scanner.nextLine();

        File newDir = new File(handle.getParent(), name);

        newDir.createNewFile();

        return newDir;
    }
}
