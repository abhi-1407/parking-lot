package strategy;

import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;

public interface ParkingStrategy {
    ParkingSpot findSpot(Vehicle vehicle);
}
