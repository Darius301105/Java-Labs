package model;

import java.util.Objects;

public class Car extends Vehicle {
    private int doors;

    public Car(String brand, double speed, String id, int mileage, int doors) {
        super(brand, speed, id, mileage);
        this.doors = doors;
    }
    public int getDoors() {
        return doors;
    }
    public void setDoors(int doors) {
        this.doors = doors;
    }
    @Override
    public void move() {
        System.out.println("model.Car " + getId() + " is driving on the road");
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 10000;
    }

    @Override
    public double rentalPrice(int days) {
        if(days <=0){
            throw new IllegalArgumentException("Days must be greater than 0");
        }

        double price = 50 *days;
        if(doors >=4){
            price = price *1.1;
        }
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Car)){
            return false;
        }
        Car car = (Car)obj;
        return Double.compare(getSpeed(), car.getSpeed()) == 0 && getMileage() == car.getMileage() && doors == car.doors
                && Objects.equals(getBrand(), car.getBrand()) &&  Objects.equals(getId(), car.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getId(), getSpeed(), getMileage(), doors);
    }

    @Override
    public String toString() {
        return super.toString() + ", doors=" + doors;
    }
}
