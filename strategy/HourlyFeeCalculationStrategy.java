//package strategy;
//
//import java.util.EnumMap;
//import java.util.Map;
//public class HourlyFeeCalculationStrategy implements FeeCalculationStrategy {
//
//
//    private final Map<VehicleType,Integer> hourlyRates;
//    public HourlyFeeCalculationStrategy() {
//        //Performance optimisation - converts this into an array
//        this.hourlyRates = new EnumMap<>(VehicleType.class);
//        hourlyRates.put(VehicleType.MOTORCYCLE,3);
//        hourlyRates.put(VehicleType.CAR,5);
//        hourlyRates.put(VehicleType.OTHER,10);
//    }
//
//    @Override
//    public int calculateParkingFee(Ticket ticket) {
//        int hours = (int)java.time.Duration.between(ticket.getEntryTime(), java.time.LocalDateTime.now()).toHours();
//        // If user exists within the first hour, they should pay the bare minimum fee
//        hours = Math.max(hours, 1);
//        return hours * getHourlyRate(ticket.getVehicle().getVehicleType());
//    }
//
//    private int getHourlyRate(VehicleType vehicleType) {
//        if(!hourlyRates.containsKey(vehicleType)){
//            return hourlyRates.get(VehicleType.OTHER);
//        }
//        return hourlyRates.get(vehicleType);
//    }
//}