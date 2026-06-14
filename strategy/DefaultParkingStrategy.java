package strategy;

import model.Floor;
import model.ParkingSpot;
import model.Vehicle;

import java.util.List;

public class DefaultParkingStrategy implements ParkingStrategy{
    private final List<Floor> floors;
    public DefaultParkingStrategy(List<Floor> floors) {
        this.floors = floors;
    }
    public ParkingSpot findSpot(Vehicle vehicle){
        for(Floor floor : floors){
            for(ParkingSpot spot : floor.getParkingSpots()){
                if(spot.isAvailable() && spot.canFitVehicle(vehicle)){
                    return spot;
                }
            }
        }
        return null;
    }
}
