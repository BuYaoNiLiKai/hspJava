package files;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Code08_BuffReader {
    public static void main(String[] args) {

    }

    @Test
    void buffReader() {
        BufferedReader br = null;
        String filePath = "hello.txt";
        String line = "";
        try {
            br = new BufferedReader(new FileReader(filePath));

            while (line != null) {
                line = br.readLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
