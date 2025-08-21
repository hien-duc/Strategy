package vn.edu.eiu.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for discount calculations and strategy management
 *
 * Demonstrates how the Strategy pattern can be extended with additional functionality
 */
public class DiscountCalculator {

    private List<DiscountStrategy> availableStrategies;

    public DiscountCalculator() {
        initializeStrategies();
    }

    /**
     * Initialize all available discount strategies
     */
    private void initializeStrategies() {
        availableStrategies = new ArrayList<>();
        availableStrategies.add(new RegularCustomerDiscount());
        availableStrategies.add(new PremiumMemberDiscount());
        availableStrategies.add(new VipMemberDiscount());
        availableStrategies.add(new HolidayPromotionDiscount());
        availableStrategies.add(new BulkOrderDiscount());
    }

    /**
     * Compare all available strategies and return the best discount
     */
    public DiscountResult findBestDiscount(double originalAmount) {
        DiscountStrategy bestStrategy = null;
        double bestFinalAmount = originalAmount;
        double maxSavings = 0;

        System.out.println("Comparing all available discount strategies:");
        System.out.println("Original Amount: $" + originalAmount + "\n");

        for (DiscountStrategy strategy : availableStrategies) {
            double finalAmount = strategy.calculateDiscount(originalAmount);
            double savings = originalAmount - finalAmount;

            System.out.println("Strategy: " + strategy.getDescription());
            System.out.println("Final Amount: $" + finalAmount + " (Savings: $" + savings + ")\n");

            if (savings > maxSavings) {
                maxSavings = savings;
                bestFinalAmount = finalAmount;
                bestStrategy = strategy;
            }
        }

        return new DiscountResult(bestStrategy, originalAmount, bestFinalAmount, maxSavings);
    }

    /**
     * Get all available strategies
     */
    public List<DiscountStrategy> getAvailableStrategies() {
        return new ArrayList<>(availableStrategies);
    }

    /**
     * Result class to encapsulate discount calculation results
     */
    public static class DiscountResult {
        private final DiscountStrategy strategy;
        private final double originalAmount;
        private final double finalAmount;
        private final double savings;

        public DiscountResult(DiscountStrategy strategy, double originalAmount,
                            double finalAmount, double savings) {
            this.strategy = strategy;
            this.originalAmount = originalAmount;
            this.finalAmount = finalAmount;
            this.savings = savings;
        }

        public DiscountStrategy getStrategy() { return strategy; }
        public double getOriginalAmount() { return originalAmount; }
        public double getFinalAmount() { return finalAmount; }
        public double getSavings() { return savings; }

        @Override
        public String toString() {
            return String.format(
                "Best Discount Found:\n" +
                "Strategy: %s\n" +
                "Original: $%.2f\n" +
                "Final: $%.2f\n" +
                "Savings: $%.2f (%.1f%%)",
                strategy.getDescription(),
                originalAmount,
                finalAmount,
                savings,
                (savings / originalAmount) * 100
            );
        }
    }
}
