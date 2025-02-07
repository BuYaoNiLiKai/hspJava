package files;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Code04_FileOut {
    public static void main(String[] args) {

    }

    @Test
    public void write() {
        FileOutputStream fos = null;
        String filePath = "hello.txt";
        try {
            if (!new File(filePath).exists()) {
                new File(filePath).createNewFile();
            }
            fos = new FileOutputStream(filePath);
            String s = "zpc,hello world";
            //     若不覆盖
            fos.write(s.getBytes(), 0, s.length() - 2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
