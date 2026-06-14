package gate;

import model.Ticket;
import model.Vehicle;
import service.ParkingService;

public class EntryGate {
    private final ParkingService parkingService;
    private final String gateId;

    public EntryGate(ParkingService parkingService, String gateId){
        this.parkingService = parkingService;
        this.gateId = gateId;
    }

    public String getGateId(){
        return gateId;
    }
    public Ticket issueTicket(Vehicle vehicle){
        return parkingService.parkVehicle(vehicle);
    }
}
