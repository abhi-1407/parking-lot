package service;

import model.ParkingLot;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingService {
    private final ParkingLot parkingLot;
    private final Map<String, Ticket> activeTickets;

    public ParkingService(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
        this.activeTickets = new HashMap<>();
    }

    private ParkingSpot findAvailableSpot(Vehicle vehicle){
        for(ParkingSpot spot:parkingLot.getParkingSpots()){
            if(spot.isAvailable() && spot.canFitVehicle(vehicle)){
                return spot;
            }
        }
        return null;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle);
        if(spot == null) {
            throw new RuntimeException("No available spot found");
        }
        spot.parkVehicle(vehicle);
        Ticket ticket = new Ticket(vehicle, spot);
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public void unparkVehicle(String ticketId){
        Ticket ticket = activeTickets.get(ticketId);
        if(ticket == null){
            throw new RuntimeException("Invalid ticket");
        }
        ParkingSpot spot = ticket.getParkingSpot();
        spot.removeVehicle();
        activeTickets.remove(ticketId);
    }
}
