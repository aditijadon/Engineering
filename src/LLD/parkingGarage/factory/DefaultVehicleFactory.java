package LLD.parkingGarage.factory;

import LLD.parkingGarage.entity.Vehicle;
import LLD.parkingGarage.enums.VehicleType;

public class DefaultVehicleFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String licensePlate, VehicleType type){
        return new Vehicle(licensePlate, type);
    }
}
