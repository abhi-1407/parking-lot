package model;

import enums.VehicleType;

public class ParkingSpot {
    private final String spotId;
    private Floor floor;
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
    public boolean parkVehicle(Vehicle vehicle){
        if(!isAvailable()){
            return false;
        }
        if(!canFitVehicle(vehicle)){
            return false;
        }
        this.parkedVehicle = vehicle;
        return true;
    }

    public Vehicle removeVehicle(){
        Vehicle vehicle = parkedVehicle;
        parkedVehicle = null;
        return vehicle;
    }
}
