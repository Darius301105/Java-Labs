public abstract class Vehicle {
    private String brand;
    private double speed;

    private String id;
    private int mileage;
    private boolean rented;

    public Vehicle(String brand, double speed, String id, int mileage) {
        this.brand = brand;
        this.speed = speed;
        this.id = id;
        this.mileage = mileage;
        this.rented = false;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public boolean isRented() {
        return rented;
    }
    public void setRented(boolean rented) {
        this.rented = rented;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void rent(){
        if(rented){
            throw new  IllegalStateException("Vehicle " + id + " is already rented!");
        }
        rented = true;
    }

    public void returnVehicle(int drivenKm) {
        if (!rented) {
            throw new IllegalStateException("Vehicle " + id + " is not currently rented!");
        }
        if (drivenKm <= 0) {
            throw new IllegalArgumentException("Driven kilometers must be greater than 0");
        }
        mileage += drivenKm;
        rented = false;
    }

    public abstract void move();
    public abstract boolean needsService();
    public abstract double rentalPrice(int days);

    @Override
    public String toString() {
        return "brand='" + brand + '\'' +
                ", speed=" + speed +
                ", id='" + id + '\'' +
                ", mileage=" + mileage +
                ", rented=" + rented;
    }
}

