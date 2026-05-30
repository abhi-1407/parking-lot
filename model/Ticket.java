package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot){
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId(){
        return ticketId;
    };
    public LocalDateTime getEntryTime(){
        return entryTime;
    };
    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    };
    public Vehicle getVehicle(){
        return vehicle;
    };



}
