package files;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class Code16_HomeWork {

    public static void main(String[] args) throws IOException {


    }

    @Test
    void work1() throws IOException {
        String FilePath = "mytmp.txt";
        File file = new File(FilePath);

        if (file.exists()) {
            System.out.println("已经存在");
        } else {
            boolean res = file.mkdirs();
            System.out.println("创建" + res);
        }
    }

    @Test
    void work2() throws IOException {
        String FilePath = "mytmp.txt";
        BufferedReader br = new BufferedReader(new FileReader(FilePath));
        String line;
        StringBuilder res = new StringBuilder();
        int row = 0;
        while ((line = br.readLine()) != null) {
            System.out.println(++row + " " + line);
        }

    }

    @Test
    void work3() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("dog.properties"));
        prop.list(System.out);
        Dog dog = new Dog(
                prop.getProperty("name"),
                Integer.parseInt(prop.getProperty("age")),
                prop.getProperty("color")
        );
        System.out.println(dog);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dog.dat"));
        oos.writeObject(dog);
        oos.close();

    }

    @Test
    void work4() throws IOException, ClassNotFoundException {
        //反序列化
        String FilePath = "dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FilePath));


        Dog dog = (Dog) ois.readObject();
        System.out.println(dog);
    }

    static class Dog implements Serializable {
        String name;
        int age;
        String color;

        public Dog(String name, int age, String color) {
            this.name = name;
            this.age = age;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}

