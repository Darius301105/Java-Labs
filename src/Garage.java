public class Garage {
    private Vehicle[] fleet;
    private int size_fleet;

    public Garage(int capacity) {
        fleet = new Vehicle[capacity];
        size_fleet = 0;
    }

    public void add(Vehicle v) {
        if(size_fleet == fleet.length) {
            throw new IllegalStateException("Garage is full");
        }
        if(findById(v.getId()) != null){
            throw new IllegalStateException("Duplicate vehicle id: " + v.getId());
        }
        fleet[size_fleet] = v;
        size_fleet++;
    }

    public Vehicle findById(String id) {
        for(int i = 0; i < size_fleet; i++) {
            if(fleet[i].getId().equals(id)) {
                return fleet[i];
            }
        }
        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);
        if(v == null){
            throw new IllegalStateException("Vehicle with id " + id + " not found");
        }
        v.rent();
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);
        if (v == null) {
            throw new IllegalArgumentException("Vehicle with id " + id + " not found.");
        }
        v.returnVehicle(drivenKm);
    }

    public void printAvailable() {
        System.out.println("\nAvailable vehicles:");
        for (int i = 0; i < size_fleet; i++) {
            if (!fleet[i].isRented()) {
                System.out.println(fleet[i]);
            }
        }
    }

    public void printNeedsService() {
        System.out.println("\nVehicles needing service:");
        for (int i = 0; i < size_fleet; i++) {
            if (fleet[i].needsService()) {
                System.out.println(fleet[i]);
            }
        }
    }

    public void printRentalEstimate(String id, int days) {
        Vehicle v = findById(id);
        if (v == null) {
            System.out.println("Vehicle with id " + id + " not found.");
            return;
        }

        System.out.println("Rental estimate for " + id + " (" + v.getClass().getSimpleName() + ") for "
                + days + " days = " + v.rentalPrice(days));
    }

    public Vehicle[] getFleet() {
        return fleet;
    }

    public int getSize() {
        return size_fleet;
    }

}
