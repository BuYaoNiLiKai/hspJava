package middle_project.homework13;

public class Person {
    private String name;
    private int age;
    private char sex;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setGae(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "姓名：" + getName() + "\n年龄：" + getAge() + "\n性别" + getSex();
    }

}
