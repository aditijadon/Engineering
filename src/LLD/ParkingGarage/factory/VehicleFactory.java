package LLD.ParkingGarage.factory;

import LLD.ParkingGarage.entity.Vehicle;
import LLD.ParkingGarage.enums.VehicleType;

public interface VehicleFactory {
    Vehicle createVehicle(String licensePlate, VehicleType type);
}
