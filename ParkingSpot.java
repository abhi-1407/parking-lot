//import model.Vehicle;
//
//
//public class ParkingSpot{
//    private final int spotNumber;
//    private final VehicleType spotType;
//    private Vehicle parkedVehicle;
//
//    public ParkingSpot(int spotNumber, VehicleType spotType) {
//        this.spotNumber = spotNumber;
//        this.spotType = spotType;
//        this.parkedVehicle = null;
//    }
//
//    public int getSpotNumber(){
//        return spotNumber;
//    }
//
//    public boolean isOccupied(){
//        return parkedVehicle != null;
//    }
//
//    public VehicleType getVehicleType(){
//        return parkedVehicle.getVehicleType();
//    }
//
//
//    public void parkVehicle(Vehicle vehicle) {
//        if (parkedVehicle != null) {
//            throw new IllegalStateException("Parking spot is already occupied");
//        }
//        if(vehicle.getVehicleType() != spotType) {
//            throw new IllegalStateException("model.Vehicle type does not match parking spot type");
//        }
//        parkedVehicle = vehicle;
//    }
//
//    public void unparkVehicle() {
//        if (parkedVehicle == null) {
//            throw new IllegalStateException("Parking spot is not occupied");
//        }
//        parkedVehicle = null;
//    }
//}