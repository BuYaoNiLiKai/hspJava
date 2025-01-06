package middle_project.homework13;

public class Student extends Person {

    private String id;

    public Student(String name, char sex, int age, String id) {
        super(name, sex, age);
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习");
    }

    public String play() {
        return getName() + "爱玩足球.";
    }

    public String toString() {
        return super.toString() + "\n学号：" + getId();
    }
}
