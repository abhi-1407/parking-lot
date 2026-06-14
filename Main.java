import enums.VehicleType;
import factory.VehicleFactory;
import gate.EntryGate;
import gate.ExitGate;
import model.*;
import model.Ticket;
import service.ParkingService;
import strategy.DefaultParkingStrategy;
import strategy.HourlyPricingStrategy;
import strategy.ParkingStrategy;
import strategy.PricingStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ParkingSpot> floor1Spots = List.of(
                new ParkingSpot("1",VehicleType.CAR),
                new ParkingSpot("2",VehicleType.BIKE)
        );

        List<ParkingSpot> floor2Spots = List.of(
                new ParkingSpot("3",VehicleType.CAR),
                new ParkingSpot("4",VehicleType.BIKE)
        );

        List<Floor> floors = List.of(
                new Floor(1, floor1Spots),
                new Floor(2, floor2Spots)
        );

        ParkingLot parkingLot = ParkingLot.getInstance("Mantri Square Mall", floors);
        PricingStrategy pricingStrategy = new HourlyPricingStrategy();
        ParkingStrategy parkingStrategy = new DefaultParkingStrategy(parkingLot.getFloors());

        ParkingService parkingService = new ParkingService(parkingLot,pricingStrategy,parkingStrategy);

        EntryGate entryGate1 = new EntryGate(parkingService,"GATE_1");
        EntryGate entryGate2 = new EntryGate(parkingService,"GATE_2");
        ExitGate exitGate1 = new ExitGate(parkingService,"GATE_1");
        ExitGate exitGate2 = new ExitGate(parkingService,"GATE_2");

        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR,"KA01AB1234");
        Vehicle bike = VehicleFactory.createVehicle(VehicleType.BIKE,"KA01AB1235");

        System.out.println("==========CAR ENTERING=============");
        Ticket ticket1 = entryGate1.issueTicket(car);
        System.out.println("Car entered from " + entryGate1.getGateId());

        System.out.println("==========BIKE ENTERING=============");
        Ticket ticket2 = entryGate2.issueTicket(bike);
        System.out.println("Bike entered from " + entryGate2.getGateId());

        System.out.println("Available number of parking slots " + parkingLot.getAvailableParkingSpots());

        System.out.println("==========CAR EXITING=============");
        exitGate1.exit(ticket1.getTicketId());
        System.out.println("Car exiting from " + exitGate1.getGateNumber());
        System.out.println("Available number of parking slots " + parkingLot.getAvailableParkingSpots());
        System.out.println("==========BIKE EXITING=============");
        exitGate2.exit(ticket2.getTicketId());
        System.out.println("Bike exiting from " + exitGate2.getGateNumber());
        System.out.println("Available number of parking slots " + parkingLot.getAvailableParkingSpots());
    }
}
