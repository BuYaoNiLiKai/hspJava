package collection_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapPractice01 {
    public static void main(String[] args) {
        HashMap<Integer, Employee1> map = new HashMap<Integer, Employee1>();
        Employee1 e1 = new Employee1("jack", 10, 5555);
        Employee1 e2 = new Employee1("tom", 20, 20000);
        Employee1 e3 = new Employee1("jack", 30, 5555);
        map.put(e1.getId(), e1);
        map.put(e2.getId(), e2);
        map.put(e3.getId(), e3);
        System.out.println(map);
        System.out.println("_________________");
        Set<Integer> keyset = map.keySet();
        for (Integer i : keyset) {
            Employee1 emp = map.get(i);
            if (emp.getSalary() > 18000) {
                System.out.println(emp);
            }
        }
        System.out.println("_______________");
        Iterator it = keyset.iterator();
        while (it.hasNext()) {
            Integer key = (Integer) it.next();
            Employee1 emp = map.get(key);
            if (emp.getSalary() > 18000) {
                System.out.println(emp);
            }
        }


    }
}

class Employee1 {
    private String name;
    private int id;
    private int salary;

    public Employee1(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                "}\n";
    }
}