package collection_;

import java.util.HashSet;
import java.util.Objects;

public class HashSetPractice02 {
    public static void main(String[] args) {
        HashSet<EmployeePlus> set = new HashSet<>();
        set.add(new EmployeePlus(2021, 4, 5, "jack", 50000));
        set.add(new EmployeePlus(2021, 4, 5, "jack", 50000));
        set.add(new EmployeePlus(2021, 4, 5, "jack2", 50000));
        set.add(new EmployeePlus(2021, 4, 5, "jack", 50000));
        System.out.println(set.size());
    }
}

class EmployeePlus {
    private String name;
    private int salary;
    private MyDate birthday;

    public EmployeePlus(int year, int month, int day, String name, int salary) {
        this.birthday = new MyDate(year, month, day);
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        return birthday.equals(((EmployeePlus) o).birthday) && name.equals(((EmployeePlus) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday.hashCode(), name, salary);
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}