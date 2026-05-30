package model;

import java.util.List;

public class ParkingLot {
    private final String name;
    private final List<ParkingSpot> parkingSpots;

    public ParkingLot(String name, List<ParkingSpot> parkingSpots){
        this.name = name;
        this.parkingSpots = parkingSpots;
    }

    public String getName(){
        return name;
    }

    public List<ParkingSpot> getParkingSpots(){
        return parkingSpots;
    }

    public int getAvailableParkingSpots(){
        int availableSpots = 0;
        for(ParkingSpot parkingSpot : parkingSpots){
            if(parkingSpot.isAvailable()){
                availableSpots++;
            }
        }
        return availableSpots;
    }

    public int getNumberOfSpots(){
        return parkingSpots.size();
    }
}
