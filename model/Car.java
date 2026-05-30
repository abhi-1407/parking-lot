package model;
import enums.*;

public class Car extends Vehicle {
    public Car(String registerationNumber){
        super(registerationNumber, VehicleType.CAR);
    }

}
