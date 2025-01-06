package java_base.poly;

public class Worker extends Employee {

    public Worker(String name, int salary) {
        super(name, salary);
    }

    public int getAnual() {
        return super.getAnnual();
    }

    public void work() {
        System.out.println("员工" + getName() + "在working");
    }
}
