package files;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class Code06_FileReader {
    public static void main(String[] args) {

    }

    @Test
    void FileReader() {
        String filePath = "hello.txt";
        FileReader fileReader = null;
        int read;
        try {
            fileReader = new FileReader(filePath);
            while ((read = fileReader.read()) != -1) {
                System.out.print((char) read);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
