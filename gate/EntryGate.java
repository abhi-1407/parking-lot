package gate;

import model.Ticket;
import model.Vehicle;
import service.ParkingService;

public class EntryGate {
    private final ParkingService parkingService;
    private final int gateNo;

    public EntryGate(ParkingService parkingService, int gateNo){
        this.parkingService = parkingService;
        this.gateNo = gateNo;
    }

    public int getGateNumber(){
        return gateNo;
    }
    public Ticket issueTicket(Vehicle vehicle){
        return parkingService.parkVehicle(vehicle);
    }
}
