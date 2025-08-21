package vn.edu.eiu.strategy;

/**
 * Concrete Strategy - Bulk Order Discount
 *
 * Implements conditional discount based on order amount
 * 30% discount for orders above $300, otherwise 10%
 */
public class BulkOrderDiscount implements DiscountStrategy {

    private static final double HIGH_DISCOUNT_RATE = 0.30; // 30% for bulk orders
    private static final double LOW_DISCOUNT_RATE = 0.10;  // 10% for regular orders
    private static final double BULK_THRESHOLD = 300.0;    // Minimum amount for bulk discount

    @Override
    public double calculateDiscount(double originalAmount) {
        double discountRate;
        String discountType;

        if (originalAmount >= BULK_THRESHOLD) {
            discountRate = HIGH_DISCOUNT_RATE;
            discountType = "Bulk Order (30%)";
        } else {
            discountRate = LOW_DISCOUNT_RATE;
            discountType = "Standard (10%)";
        }

        double discountAmount = originalAmount * discountRate;
        double finalAmount = originalAmount - discountAmount;

        System.out.println("   Applying " + discountType + " discount");
        System.out.println("   Discount amount: $" + discountAmount);

        return finalAmount;
    }

    @Override
    public String getDescription() {
        return "Bulk Order Discount - 30% for orders ≥ $300, otherwise 10%";
    }
}
