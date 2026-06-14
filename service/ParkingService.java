package service;

import exception.InvalidTicketException;
import exception.NoSpotAvailableException;
import model.*;
import strategy.ParkingStrategy;
import strategy.PricingStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingService {
    private final ParkingLot parkingLot;
    private final PricingStrategy pricingStrategy;
    private final ParkingStrategy parkingStrategy;
    private final Map<String, Ticket> activeTickets;
    private final ReentrantLock lock = new ReentrantLock();

    public ParkingService(ParkingLot parkingLot,PricingStrategy strategy,ParkingStrategy parkingStrategy){
        this.parkingLot = parkingLot;
        this.pricingStrategy = strategy;
        this.parkingStrategy = parkingStrategy;
        this.activeTickets = new HashMap<>();
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        lock.lock();
        try{
            ParkingSpot spot = parkingStrategy.findSpot(vehicle);
            if (spot == null) {
                throw new NoSpotAvailableException();
            }
            spot.parkVehicle(vehicle);
            Ticket ticket = new Ticket(vehicle, spot);
            activeTickets.put(ticket.getTicketId(), ticket);
            return ticket;
        }finally {
            lock.unlock();
        }
    }

    public double unparkVehicle(String ticketId){
        lock.lock();
        Ticket ticket = activeTickets.get(ticketId);
        if(ticket == null){
            throw new InvalidTicketException();
        }
        ParkingSpot spot = ticket.getParkingSpot();
        spot.removeVehicle();
        double charge = pricingStrategy.calculateFee(ticket);
        activeTickets.remove(ticketId);
        return charge;
    }
}
