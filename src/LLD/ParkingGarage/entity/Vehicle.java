package LLD.ParkingGarage.entity;

import LLD.ParkingGarage.enums.VehicleType;

public class Vehicle {
    private final String licensePlate;
    private final VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be null or empty");
        }
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicenseNumber() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

/* Making class immutable so that these values remain constant throughout the object’s lifecycle.
* Vehicle can only be created by constructor call.
* */
