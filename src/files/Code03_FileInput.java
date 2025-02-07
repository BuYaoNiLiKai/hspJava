package files;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Code03_FileInput {
    public static void main(String[] args) {

    }

    @Test
    public void readFile() {
        String filePath = "hello.txt";
        int read;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
//            read = fis.read();
            while ((read = fis.read()) != -1) {
                System.out.println((char) read);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
                System.out.println("close");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void readFileByte() {
        byte[] bytes = new byte[10];
        String filePath = "hello.txt";
        FileInputStream fis = null;
        int len = 0;
        try {
            fis = new FileInputStream(filePath);
//            read = fis.read();
            while ((len = fis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fis.close();
                System.out.println("close");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
