import model.ParkingSpot;
import model.Vehicle;

import java.time.*;
import java.util.UUID;
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

    public LocalDateTime getEntryTime(){
        return entryTime;
    };

    public String getTicketNumber(){
        return ticketNumber;
    };

    public Vehicle getVehicle(){
        return vehicle;
    }


    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }


}