package app;

import model.Car;
import model.Motorcycle;
import model.Truck;
import model.Vehicle;
import service.Garage;

public class Demo {
    public static void main(String[] args) {
        Garage garage = new Garage(10);

        Car car1 = new Car("Toyota", 180, "C101", 9500, 4);
        Car car2 = new Car("Toyota", 180, "C101", 9500, 4);
        Car car3 = new Car("BMW", 240, "C102", 12000, 2);

        Motorcycle moto1 = new Motorcycle("Yamaha", 160, "M201", 5000, false);
        Motorcycle moto2 = new Motorcycle("Honda", 140, "M202", 6500, true);

        Truck truck1 = new Truck("Volvo", 120, "T301", 14000, 8000);
        Truck truck2 = new Truck("MAN", 110, "T302", 16000, 12000);

        garage.add(car1);
        garage.add(car3);
        garage.add(moto1);
        garage.add(moto2);
        garage.add(truck1);
        garage.add(truck2);

        Vehicle[] vehicles = {
                car1, car3, moto1, moto2, truck1, truck2
        };

        for (Vehicle v : vehicles) {
            v.move();
        }

        System.out.println("car1 equals car2? " + car1.equals(car2));
        System.out.println("car1 equals car3? " + car1.equals(car3));

        System.out.println("\nRenting vehicles");
        garage.rentById("C101");
        garage.rentById("T301");

        garage.printAvailable();

        System.out.println("\nRental estimates");
        garage.printRentalEstimate("C101", 3);
        garage.printRentalEstimate("M202", 4);
        garage.printRentalEstimate("T301", 2);

        System.out.println("\nReturning vehicles");
        garage.returnById("C101", 700);
        garage.returnById("T301", 1500);

        garage.printNeedsService();

        garage.printAvailable();
    }
}