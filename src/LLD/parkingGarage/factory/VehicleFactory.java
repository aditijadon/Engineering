package LLD.parkingGarage.factory;

import LLD.parkingGarage.entity.Vehicle;
import LLD.parkingGarage.enums.VehicleType;

public interface VehicleFactory {
    Vehicle createVehicle(String licensePlate, VehicleType type);
}
