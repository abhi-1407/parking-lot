package model;

import enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String registerationNumber){
        super(registerationNumber, VehicleType.BIKE);
    }

}