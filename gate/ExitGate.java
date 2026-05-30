package gate;

import model.Ticket;
import model.Vehicle;
import service.ParkingService;

public class ExitGate {
    private final ParkingService parkingService;
    private final int gateNo;

    public ExitGate(ParkingService parkingService,int gateNo){
        this.parkingService = parkingService;
        this.gateNo = gateNo;
    }

    public int getGateNumber(){
        return gateNo;
    }

    public double exit(String ticketId){
        return parkingService.unparkVehicle(ticketId);
    }
}
