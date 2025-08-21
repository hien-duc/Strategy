package vn.edu.eiu.strategy;

/**
 * Concrete Strategy - Premium Member Discount
 *
 * Implements 10% discount for premium members
 */
public class PremiumMemberDiscount implements DiscountStrategy {

    private static final double DISCOUNT_RATE = 0.10; // 10% discount

    @Override
    public double calculateDiscount(double originalAmount) {
        double discountAmount = originalAmount * DISCOUNT_RATE;
        double finalAmount = originalAmount - discountAmount;

        System.out.println("   Applying Premium Member discount: 10%");
        System.out.println("   Discount amount: $" + discountAmount);

        return finalAmount;
    }

    @Override
    public String getDescription() {
        return "Premium Member - 10% discount on all purchases";
    }
}
