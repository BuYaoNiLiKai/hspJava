package java_base.poly;

public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getAnnual() {
        return 12 * salary;
    }

    public String getName() {
        return name;
    }

}
