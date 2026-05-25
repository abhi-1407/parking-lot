public class HourlyFeeCalculationStrategy implements FeeCalculationStrategy {
    private Map<VehicleType, Integer> hourlyRates;

    public HourlyFeeCalculationStrategy() {
        hourlyRates = new HashMap<>();
        hourlyRates.put(VehicleType.CAR, 5);
        hourlyRates.put(VehicleType.MOTORCYCLE, 3);
        hourlyRates.put(VehicleType.OTHER, 10);
    }

    @Override
    public int calculateParkingFee(Ticket ticket) {
        int hours = java.time.Duration.between(ticket.getEntryTime(), java.time.LocalDateTime.now()).toHours();
        // If user exists within the first hour, they should pay the bare minimum fee
        hours = Math.max(hours, 1);
        return hours * getHourlyRate(ticket.getVehicle().getType());
    }

    private int getHourlyRate(VehicleType vehicleType) {
        return hourlyRates.get(vehicleType);
    }
}