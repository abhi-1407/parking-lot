package strategy;

import model.Ticket;

public class FlatRatePricingStrategy implements PricingStrategy {
    @Override
    public double calculateFee(Ticket ticket) {
        return 50.0;
    }
}