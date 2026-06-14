import enums.VehicleType;
import factory.VehicleFactory;
import gate.EntryGate;
import gate.ExitGate;
import model.*;
import model.Ticket;
import service.ParkingService;
import strategy.DefaultParkingStrategy;
import strategy.FlatRatePricingStrategy;
import strategy.ParkingStrategy;
import strategy.PricingStrategy;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ParkingSpot carSpot1 = new ParkingSpot("C1", VehicleType.CAR);

        ParkingSpot carSpot2 = new ParkingSpot("C2", VehicleType.CAR);

        ParkingSpot bikeSpot1 = new ParkingSpot("B1", VehicleType.BIKE);

        ParkingSpot truckSpot1 = new ParkingSpot("T1", VehicleType.TRUCK);

        Floor floor1 = new Floor(1, List.of(carSpot1, carSpot2, bikeSpot1, truckSpot1));

        ParkingLot parkingLot = new ParkingLot("Phoenix Mall");

        parkingLot.addFloor(floor1);

        ParkingStrategy parkingStrategy = new DefaultParkingStrategy(parkingLot.getFloors());

        PricingStrategy pricingStrategy = new FlatRatePricingStrategy();

        ParkingService parkingService = new ParkingService(parkingLot, pricingStrategy, parkingStrategy);

        EntryGate entryGate = new EntryGate(parkingService, "GATE_1");

        ExitGate exitGate = new ExitGate(parkingService, "GATE_2");

        parkingLot.addEntryGate(entryGate);
        parkingLot.addExitGate(exitGate);

        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR, "KA01AB1234");

        Ticket ticket = entryGate.issueTicket(car);

        System.out.println("Ticket Generated : " + ticket.getTicketId());

        System.out.println("Vehicle Parked At Spot : " + ticket.getParkingSpot().getSpotId());

        double fee = exitGate.exit(ticket.getTicketId());

        System.out.println("Parking Fee : " + fee);
    }
}