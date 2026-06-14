package model;
import enums.*;

public class Car extends Vehicle {
    public Car(String registrationNumber){
        super(registrationNumber, VehicleType.CAR);
    }

}
