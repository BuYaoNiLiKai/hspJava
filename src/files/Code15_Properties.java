package files;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Code15_Properties {
    public static void main(String[] args) throws IOException {

    }

    @Test
    void traditional() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mysql.properties"));
        String line;
        while ((line = br.readLine()) != null) {

            System.out.println(line);
            System.out.println(line.split("=")[1]);
        }
        br.close();
    }

    @Test
    void prop() throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("mysql.properties"));
        Properties prop = new Properties();
        prop.load(new FileReader("mysql.properties"));
        prop.list(System.out);
        System.out.println(prop.getProperty("pwd"));
        prop.setProperty("charset", "gbk");

        System.out.println(prop.getProperty("charset"));
    }

    @Test
    void prop2() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("pwd", "1234567");
        prop.setProperty("charset", "gbk");
        prop.setProperty("user", "汤姆");
        prop.store(
                new FileOutputStream("mysql2.properties"), "hello"
        );

    }
}
