public class Ticket {
    private String ticketNumber;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot parkingSpot;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketNumber = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
        this.parkingSpot = parkingSpot;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }


}