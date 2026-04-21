package model;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, double speed, String id, int mileage, boolean hasSidecar) {
        super(brand, speed, id, mileage);
        this.hasSidecar = hasSidecar;
    }
    public boolean hasSidecar() {
        return hasSidecar;
    }
    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void move() {
        System.out.println("model.Motorcycle " + getId() + " is speeding through traffic.");
    }

    @Override
    public boolean needsService() {
        return getMileage() >= 6000;
    }

    @Override
    public double rentalPrice(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than 0.");
        }
        double price = 30 * days;
        if (hasSidecar) {
            price += 15 * days;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasSidecar=" + hasSidecar;
    }
}
