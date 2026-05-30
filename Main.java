import enums.VehicleType;
import model.Car;
import model.ParkingLot;
import model.ParkingSpot;
import model.Ticket;
import service.ParkingService;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ParkingSpot> spots = List.of(
                new ParkingSpot("1",VehicleType.CAR),
                new ParkingSpot("1",VehicleType.BIKE)
        );
        ParkingLot parkingLot = new ParkingLot("Mantri Square Mall", spots);
        ParkingService parkingService = new ParkingService(parkingLot);

        Car car = new Car("KA01AB1234");

        Ticket ticket1 = parkingService.parkVehicle(car);

        System.out.println("Total Number of parking spots " + parkingLot.getNumberOfSpots());
        System.out.println("Available number of parking slots " + parkingLot.getAvailableParkingSpots());
        System.out.println("REMOVING CARRRRR");

        parkingService.unparkVehicle(ticket1.getTicketId());
        System.out.println("Available number of parking slots " + parkingLot.getAvailableParkingSpots());
    }
}
