package model;

import enums.VehicleType;

public abstract class Vehicle {
    private final String registrationNumber;
    private final VehicleType vehicleType;

    public Vehicle(String registrationNumber, VehicleType vehicleType){
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }
    public String getRegistrationNumber(){
        return registrationNumber;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

}