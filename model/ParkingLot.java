package model;

import java.util.List;

public class ParkingLot {
    private final String name;
    private static ParkingLot instance;
    private final List<Floor> floors;

    private ParkingLot(String name, List<Floor> floors){
        this.name = name;
        this.floors = floors;
    }

    public int getAvailableParkingSpots(){
        int count = 0;
        for(Floor floor : floors){
            for(ParkingSpot spot : floor.getParkingSpots()){
                if(spot.isAvailable()){
                    count++;
                }
            }
        }
        return count;
    }

    public static ParkingLot getInstance(String name,List<Floor> floors){
        if(instance == null){
            instance = new ParkingLot(name,floors);
        }
        return instance;
    }

    public List<Floor> getFloors(){
        return floors;
    }

}
