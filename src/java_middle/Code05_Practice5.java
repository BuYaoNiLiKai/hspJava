package java_middle;

public class Code05_Practice5 {
    public static void main(String[] args) {

        Person p = new Person("唐僧");
        p.setVehicle(true);
        p.show();
    }
}

interface Vehicle {
    void work();
}

class Horse implements Vehicle {

    @Override
    public void work() {
        System.out.println("Horse work");
    }
}

class Boat implements Vehicle {

    @Override
    public void work() {
        System.out.println("Boat work");
    }
}

class VehicleFactory {
    public static Vehicle getHorse() {
        return new Horse();
    }

    public static Vehicle getBoat() {
        return new Boat();
    }
}

class Person {
    private String name;
    private Vehicle vehicle;

    public Person(String name) {
        this.name = name;
    }

    public void setVehicle(Boolean isRiver) {
        if (isRiver) {
            this.vehicle = VehicleFactory.getBoat();
        } else {
            this.vehicle = VehicleFactory.getHorse();
        }
    }

    public void show() {
        System.out.println(this.name);
        this.vehicle.work();
    }
}
