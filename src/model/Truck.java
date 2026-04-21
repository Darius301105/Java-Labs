package model;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String brand, double speed, String id, int mileage, double loadCapacity) {
        super(brand, speed, id, mileage);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void move() {
        System.out.println("model.Truck " + getId() + " is transporting heavy cargo.");
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 15000;
    }

    @Override
    public double rentalPrice(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than 0.");
        }
        return (80 + 0.02 * loadCapacity) * days;
    }

    @Override
    public String toString() {
        return super.toString() + ", loadCapacity=" + loadCapacity;
    }
}
