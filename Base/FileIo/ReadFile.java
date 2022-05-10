package Base.FileIo;

import java.io.*;

public class ReadFile {
    public static final String FILE = "." + File.separator + "read.txt";
    public static void main(String[] args) {
        File file = new File(FILE);

        normalReadFile(file);
        System.out.println("===========");
        lambdaReadFile(file);
    }

    public static void normalReadFile(File file) {
        try (
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lambdaReadFile(File file) {
        try (
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
        ) {
            br.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
