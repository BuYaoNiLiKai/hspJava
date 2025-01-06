package collection_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetPeactice {
    public static void main(String[] args) {
        HashSet<Employee> set = new HashSet<Employee>(
        );
        set.add(new Employee("Jane Doe", 40000));
        set.add(new Employee("Jane Doe", 40000));
        set.add(new Employee("Jane Doe", 40000));
        System.out.println(set);
        System.out.println(set.size());

    }
}

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        System.out.println("hello world");
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
