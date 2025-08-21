package vn.edu.eiu.strategy;

/**
 * Concrete Strategy - Regular Customer Discount
 *
 * Implements no discount for regular customers
 */
public class RegularCustomerDiscount implements DiscountStrategy {

    @Override
    public double calculateDiscount(double originalAmount) {
        // No discount for regular customers
        System.out.println("   Applying Regular Customer discount: 0%");
        return originalAmount;
    }

    @Override
    public String getDescription() {
        return "Regular Customer - No discount applied";
    }
}
