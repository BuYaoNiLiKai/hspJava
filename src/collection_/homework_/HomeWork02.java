package collection_.homework_;

import java.util.ArrayList;

public class HomeWork02 {
    public static void main(String[] args) {
        ArrayList catList = new ArrayList();
        Car car1 = new Car("宝马", 6545654);
        Car car2 = new Car("宾利", 56426565);
        catList.add(car1);
        catList.add(car2);
        System.out.println(catList);

        catList.remove(car1);
        System.out.println(catList);

        System.out.println(catList.contains(car1));
        System.out.println(catList.size());
        System.out.println(catList.isEmpty());
        catList.clear();
        System.out.println(catList);

        ArrayList catList1 = new ArrayList();
        catList1.add(car1);
        catList1.add(car2);

        catList.addAll(catList1);
        System.out.println(catList1);

        catList.removeAll(catList1);
        System.out.println(catList);
        for (Object c : catList1) {
            System.out.println((Car) c);
        }

    }
}

class Car {
    String name;
    double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}