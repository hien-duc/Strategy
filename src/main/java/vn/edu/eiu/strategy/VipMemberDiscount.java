package vn.edu.eiu.strategy;

/**
 * Concrete Strategy - VIP Member Discount
 *
 * Implements 20% discount for VIP members
 */
public class VipMemberDiscount implements DiscountStrategy {

    private static final double DISCOUNT_RATE = 0.20; // 20% discount

    @Override
    public double calculateDiscount(double originalAmount) {
        double discountAmount = originalAmount * DISCOUNT_RATE;
        double finalAmount = originalAmount - discountAmount;

        System.out.println("   Applying VIP Member discount: 20%");
        System.out.println("   Discount amount: $" + discountAmount);

        return finalAmount;
    }

    @Override
    public String getDescription() {
        return "VIP Member - 20% discount on all purchases";
    }
}
