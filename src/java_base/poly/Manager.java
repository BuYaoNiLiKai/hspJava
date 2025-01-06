package java_base.poly;

public class Manager extends Employee {
    private int bonus;

    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("管理员" + getName() + "正在管理");
    }

    public int getAnnual() {
        return super.getAnnual() + bonus;
    }
}
