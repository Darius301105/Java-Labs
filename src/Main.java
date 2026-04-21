//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", 180, "C101", 9500, 4);
        Car car2 = new Car("BMW", 220, "C102", 12000, 2);
        Car car3 = new Car("Toyota", 180, "C101", 9500, 4);

        Motorcycle moto1 = new Motorcycle("Yamaha", 160, "M201", 5000, false);
        Motorcycle moto2 = new Motorcycle("Honda", 140, "M202", 6500, true);

        Truck truck1 = new Truck("Volvo", 120, "T301", 14000, 8000);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(moto1);
        System.out.println(moto2);
        System.out.println(truck1);

        Vehicle[] vehicles = {car1, car2, moto1, moto2, truck1};

        for (Vehicle v : vehicles) {
            v.move();
        }

        for (Vehicle v : vehicles) {
            System.out.println(v.getId() + " needs service? " + v.needsService());
        }

        for (Vehicle v : vehicles) {
            System.out.println(v.getId() + " price for 3 days = " + v.rentalPrice(3));
        }

        System.out.println("car1 equals car2? " + car1.equals(car2));
        System.out.println("car1 equals car3? " + car1.equals(car3));

        System.out.println("Initial rented status for car1: " + car1.isRented());
        car1.rent();
        System.out.println("After rent, car1 rented? " + car1.isRented());

        car1.returnVehicle(500);
        System.out.println("After return, car1 rented? " + car1.isRented());
        System.out.println("car1 new mileage: " + car1.getMileage());

    }
}