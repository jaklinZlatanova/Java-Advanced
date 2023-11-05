package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {

    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (this.vehicles.size() < this.capacity) {
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        return this.vehicles.removeIf(e ->
                e.getVIN().equals(vin));
    }

    public int getCount() {
        return this.vehicles.size();

    }

    public Vehicle getLowestMileage() {
        return this.vehicles.stream()
                .min(Comparator.comparingInt(Vehicle::getMileage))
                .orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Vehicles in the preparatory"));

        this.vehicles.forEach(v -> {
            sb.append(System.lineSeparator());
            sb.append(v);
        });

        return sb.toString();
    }
}


