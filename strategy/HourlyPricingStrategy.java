package strategy;

import model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy{
    private static final double HOURLY_RATE = 20;
    @Override
    public double calculateFee(Ticket ticket) {
        long hours = Math.max(1,Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours());
        return hours * HOURLY_RATE;
    }
}
