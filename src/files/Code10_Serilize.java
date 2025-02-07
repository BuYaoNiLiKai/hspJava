package files;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Code10_Serilize {
    public static void main(String[] args) {

    }

    @Test
    void serilize() throws IOException {

        Dog dog = new Dog("小黄", 3);
        String filePath = "dog.dat";
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeInt(100);
            objectOutputStream.writeInt(200);
            objectOutputStream.writeUTF("hello");
            objectOutputStream.writeObject(dog);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            objectOutputStream.close();
        }


    }

    @Test
    void deserilize() throws IOException, ClassNotFoundException {
        String filePath = "dog.dat";
        ObjectInputStream objectInputStream = null;
        objectInputStream = new ObjectInputStream(
                new FileInputStream(filePath)
        );
        Dog dog = null;
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readUTF());
        System.out.println(objectInputStream.readObject());
//        dog = (Dog) objectInputStream.readObject();
//        objectInputStream.close();
//        System.out.println(dog.toString());

    }
}

class Dog implements Serializable {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
