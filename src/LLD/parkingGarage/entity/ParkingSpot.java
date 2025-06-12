package LLD.parkingGarage.entity;

import LLD.parkingGarage.enums.VehicleType;
import LLD.parkingGarage.exception.ParkingLotException;

public class ParkingSpot {
    private final int spotId; // final because id of spot never changes
    private final VehicleType type; // final because type of spot never changes
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(int spotId, VehicleType type) {
        this.spotId = spotId;
        this.type = type;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (!isAvailable()) {
            throw new ParkingLotException("Spot " + spotId + " is already occupied");
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void unparkVehicle() {
        if (isAvailable()) {
            throw new ParkingLotException("Spot " + spotId + " is already empty");
        }
        this.vehicle = null;
        this.isOccupied = false;
    }

    public int getSpotId() {
        return spotId;
    }

    public VehicleType getType() {
        return type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
