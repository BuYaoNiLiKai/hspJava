package files;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Code09_BufferedWriter {
    public static void main(String[] args) {

    }

    @Test
    public void bufferedWriter() {
        String filePath = "hello.txt";
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(
                    new FileWriter(filePath)
            );
            bufferedWriter.write("yyyy");
            bufferedWriter.newLine();
            bufferedWriter.write("asafaf");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

