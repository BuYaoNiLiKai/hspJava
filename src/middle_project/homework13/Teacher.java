package middle_project.homework13;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教课");
    }

    public String play() {
        return getName() + "爱玩象棋";
    }

    public String toString() {
        return super.toString() + "\n工龄" + getWork_age();
    }


}
