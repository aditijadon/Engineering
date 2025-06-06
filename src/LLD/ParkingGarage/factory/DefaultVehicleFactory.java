package LLD.ParkingGarage.factory;

import LLD.ParkingGarage.entity.Vehicle;
import LLD.ParkingGarage.enums.VehicleType;

public class DefaultVehicleFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle(String licensePlate, VehicleType type){
        return new Vehicle(licensePlate, type);
    }
}
