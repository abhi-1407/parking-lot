public class EntryGate {
    private String gateId;
    private SpotAllocationStrategy spotAllocationStrategy;

    EntryGate(SpotAllocationStrategy spotAllocationStrategy, String gateId) {
        this.spotAllocationStrategy = spotAllocationStrategy;
        this.gateId = gateId;
    }

    public Ticket allocateSpot(Vehicle vehicle) {
        ParkingSpot parkingSpot = spotAllocationStrategy.allocateSpot(vehicle);
        if(parkingSpot == null) {
            System.out.println("No spot available");
            return;
        }
        parkingSpot.parkVehicle(vehicle);

        Ticket ticket = new Ticket(vehicle, parkingSpot);
        System.out.println("Ticket generated: " + ticket.getTicketNumber());
        return ticket;
    }

}