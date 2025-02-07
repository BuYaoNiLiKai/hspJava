package files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Code12_CodeQuestion {
    public static void main(String[] args) throws IOException {

        // 乱码问题
        FileInputStream fis = null;
        String filePath = "hello.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = "";
        System.out.println("读取内容：");
        line = br.readLine();
        System.out.println(line);


    }
}
