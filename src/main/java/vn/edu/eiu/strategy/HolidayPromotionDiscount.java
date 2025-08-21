package vn.edu.eiu.strategy;

/**
 * Concrete Strategy - Holiday Promotion Discount
 *
 * Implements 25% discount for holiday promotions
 */
public class HolidayPromotionDiscount implements DiscountStrategy {

    private static final double DISCOUNT_RATE = 0.25; // 25% discount

    @Override
    public double calculateDiscount(double originalAmount) {
        double discountAmount = originalAmount * DISCOUNT_RATE;
        double finalAmount = originalAmount - discountAmount;

        System.out.println("   Applying Holiday Promotion discount: 25%");
        System.out.println("   Discount amount: $" + discountAmount);

        return finalAmount;
    }

    @Override
    public String getDescription() {
        return "Holiday Promotion - 25% discount (Limited time offer!)";
    }
}
