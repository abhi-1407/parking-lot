package factory;

import enums.VehicleType;
import model.Bike;
import model.Car;
import model.Truck;
import model.Vehicle;

public class VehicleFactory {
    public static Vehicle createVechicle(VehicleType vehicleType, String registrationNumber){
        switch(vehicleType){
            case CAR:
                return new Car(registrationNumber);
            case BIKE:
                return new Bike(registrationNumber);
            case TRUCK:
                return new Truck(registrationNumber);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }
}
