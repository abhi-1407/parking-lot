package gate;

import model.Ticket;
import model.Vehicle;
import service.ParkingService;

public class ExitGate {
    private final ParkingService parkingService;
    private final String gateId;

    public ExitGate(ParkingService parkingService,String gateId){
        this.parkingService = parkingService;
        this.gateId = gateId;
    }

    public String getGateNumber(){
        return gateId;
    }

    public double exit(String ticketId){
        return parkingService.unparkVehicle(ticketId);
    }
}
