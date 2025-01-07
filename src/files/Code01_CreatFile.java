package files;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Code01_CreatFile {
    public static void main(String[] args) {

    }

    @Test
    public void create01() {
        String filePath = "hello.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());


    }

    public void create02() {

    }
}
