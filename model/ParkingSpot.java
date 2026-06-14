package model;

import enums.VehicleType;

public class ParkingSpot {
    private final String spotId;
    private final VehicleType spotType;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, VehicleType vehicleType){
        this.spotId = spotId;
        this.spotType = vehicleType;
    }

    public boolean isAvailable(){
        return parkedVehicle == null;
    }

    public boolean canFitVehicle(Vehicle vehicle){
        return vehicle.getVehicleType() == spotType;
    }
    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
    }

    public Vehicle removeVehicle(){
        Vehicle vehicle = parkedVehicle;
        parkedVehicle = null;
        return vehicle;
    }
}
