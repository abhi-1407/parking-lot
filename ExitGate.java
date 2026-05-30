//public class ExitGate{
//    private String gateId;
//    private FeeCalculationStrategy feeCalculationStrategy;
//
//    ExitGate(FeeCalculationStrategy feeCalculationStrategy, String gateId) {
//        this.feeCalculationStrategy = feeCalculationStrategy;
//        this.gateId = gateId;
//    }
//
//    public void exitVehicle(Ticket ticket) {
//        ParkingSpot parkingSpot = ticket.getParkingSpot();
//        if(parkingSpot == null) {
//            System.out.println("No parking spot found");
//            return;
//        }
//
//        int parkingFee = feeCalculationStrategy.calculateParkingFee(ticket);
//        System.out.println("Ticket number: " + ticket.getTicketNumber());
//        System.out.println("Parking fee: " + parkingFee);
//
//        parkingSpot.unparkVehicle();
//        System.out.println("model.Vehicle exited");
//    }
//}