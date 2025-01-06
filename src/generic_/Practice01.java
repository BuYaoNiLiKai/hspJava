package generic_;

import java.util.ArrayList;
import java.util.Comparator;

public class Practice01 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 5000, 2002, 6, 8));
        employees.add(new Employee("jack", 5000, 2002, 6, 7));
        employees.add(new Employee("ack", 5000, 2002, 6, 8));
        employees.add(new Employee("ack", 5000, 2001, 6, 7));
        System.out.println(employees);
        employees.sort(new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName().compareTo(o2.getName()) == 0) {
                    if (o1.getBirthday().getYear() == o2.getBirthday().getYear()) {
                        if (o1.getBirthday().getMonth() == o2.getBirthday().getMonth()) {
                            return o1.getBirthday().getDay() - o2.getBirthday().getDay();
                        }
                        return o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                    }
                    return o1.getBirthday().getYear() - o2.getBirthday().getYear();
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(employees);

    }
}

class Employee {
    private String name;
    private int salary;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, int salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.birthday = new MyDate(year, month, day);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                "}\n";
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

