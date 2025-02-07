package files;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class Code07_FileWriter {
    public static void main(String[] args) {

    }

    @Test
    void fileWriter() {
        String filePath = "hello.txt";
        FileWriter fileWriter = null;
        String info = "宗培超";
        try {
            fileWriter = new FileWriter(filePath, true);
            fileWriter.write(info);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
