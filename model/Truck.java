package  model;

import enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String registerationNumber){
        super(registerationNumber, VehicleType.TRUCK);
    }

}