package service;

import model.*;
import strategy.PricingStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingService {
    private final ParkingLot parkingLot;
    private final PricingStrategy pricingStrategy;
    private final Map<String, Ticket> activeTickets;

    public ParkingService(ParkingLot parkingLot,PricingStrategy strategy){
        this.parkingLot = parkingLot;
        this.pricingStrategy = strategy;
        this.activeTickets = new HashMap<>();
    }

    private ParkingSpot findAvailableSpot(Vehicle vehicle){
        for(Floor floor : parkingLot.getFloors()){
            for(ParkingSpot spot : floor.getParkingSpots()){
                if(spot.isAvailable() && spot.canFitVehicle(vehicle)){
                    return spot;
                }
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

    public double unparkVehicle(String ticketId){
        Ticket ticket = activeTickets.get(ticketId);
        if(ticket == null){
            throw new RuntimeException("Invalid ticket");
        }
        ParkingSpot spot = ticket.getParkingSpot();
        spot.removeVehicle();
        double charge = pricingStrategy.calculateFee(ticket);
        activeTickets.remove(ticketId);
        return charge;
    }
}
