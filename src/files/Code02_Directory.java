package files;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Code02_Directory {

    @Test
    public void m1() {
        String filePath = "hello.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("failed");
            }
        } else {
            System.out.println("文件不存在");
        }
    }

    public static void main(String[] args) {

    }
}
