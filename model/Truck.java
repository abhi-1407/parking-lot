package  model;

import enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String registrationNumber){
        super(registrationNumber, VehicleType.TRUCK);
    }

}