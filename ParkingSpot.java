public class ParkingSpot{
    private int spotNumber;
    private VehicleType spotType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.parkedVehicle = null;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (parkedVehicle != null) {
            throw new IllegalStateException("Parking spot is already occupied");
        }
        if(vehicle.getType() != spotType) {
            throw new IllegalStateException("Vehicle type does not match parking spot type");
        }
        parkedVehicle = vehicle;
    }

    public void unparkVehicle() {
        if (parkedVehicle == null) {
            throw new IllegalStateException("Parking spot is not occupied");
        }
        parkedVehicle = null;
    }
}