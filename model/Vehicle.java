package model;

import enums.VehicleType;

public abstract class Vehicle {
    private final String registerationNumber;
    private final VehicleType vehicleType;

    public Vehicle(String registerationNumber, VehicleType vehicleType){
        this.registerationNumber = registerationNumber;
        this.vehicleType = vehicleType;
    }
    public String getRegisterationNumber(){
        return registerationNumber;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

}