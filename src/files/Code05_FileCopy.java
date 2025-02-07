package files;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Code05_FileCopy {
    public static void main(String[] args) {

    }

    @Test
    void fileCopy() {
        String fromPath = "hello.txt";
        FileInputStream fis = null;
        FileOutputStream fos = null;
        int read;
        StringBuilder info = new StringBuilder();
        String toPath = "new.txt";
        try {
            fis = new FileInputStream(fromPath);
            while ((read = fis.read()) != -1) {
                char ch = (char) read;
                info.append(ch);
            }
            fos = new FileOutputStream(toPath);
            fos.write(info.toString().getBytes());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
