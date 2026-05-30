//package strategy;
//
//import model.Vehicle;
//
//import java.util.List;
//
//public class NearestSpotAllocationStrategy implements SpotAllocationStrategy {
//    private final List<ParkingSpot> allSpots;
//
//    public NearestSpotAllocationStrategy(List<ParkingSpot> spots){
//        this.allSpots = spots;
//    }
//    @Override
//    public ParkingSpot allocateSpot(Vehicle vehicle) {
//        for(ParkingSpot spot : allSpots){
//            if(!spot.isOccupied() && spot.getVehicleType() == vehicle.getVehicleType()){
//                return spot;
//            }
//        }
//        return null;
//    }
//}
