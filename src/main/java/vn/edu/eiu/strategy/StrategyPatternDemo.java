package vn.edu.eiu.strategy;

/**
 * Advanced Strategy Pattern Demonstration
 *
 * This class shows more advanced usage of the Strategy pattern including
 * lambda expressions and functional interfaces (Java 8+ features)
 */
public class StrategyPatternDemo {

    public static void demonstrateAdvancedFeatures() {
        System.out.println("=== Advanced Strategy Pattern Features ===\n");

        ShoppingCart cart = new ShoppingCart();
        double orderAmount = 500.0;

        System.out.println("Order Amount: $" + orderAmount + "\n");

        // Using lambda expressions as strategies (Java 8+)
        System.out.println("1. Using Lambda Expression - Student Discount (15%):");
        cart.setDiscountStrategy(new DiscountStrategy() {
            @Override
            public double calculateDiscount(double originalAmount) {
                double discount = originalAmount * 0.15;
                System.out.println("   Applying Student discount: 15%");
                System.out.println("   Discount amount: $" + discount);
                return originalAmount - discount;
            }

            @Override
            public String getDescription() {
                return "Student Discount - 15% off with valid student ID";
            }
        });
        System.out.println("   Final Amount: $" + cart.calculateTotal(orderAmount) + "\n");

        // Using method reference
        System.out.println("2. Bulk Order Discount (30% for orders > $300):");
        cart.setDiscountStrategy(new BulkOrderDiscount());
        System.out.println("   Final Amount: $" + cart.calculateTotal(orderAmount) + "\n");

        // Conditional strategy selection
        System.out.println("3. Dynamic Strategy Selection:");
        DiscountStrategy dynamicStrategy = selectStrategyBasedOnAmount(orderAmount);
        cart.setDiscountStrategy(dynamicStrategy);
        System.out.println("   Final Amount: $" + cart.calculateTotal(orderAmount) + "\n");
    }

    /**
     * Demonstrates dynamic strategy selection based on order amount
     */
    private static DiscountStrategy selectStrategyBasedOnAmount(double amount) {
        if (amount >= 1000) {
            System.out.println("   Auto-selected: VIP Member discount (high-value order)");
            return new VipMemberDiscount();
        } else if (amount >= 500) {
            System.out.println("   Auto-selected: Premium Member discount (medium-value order)");
            return new PremiumMemberDiscount();
        } else {
            System.out.println("   Auto-selected: Regular Customer discount (standard order)");
            return new RegularCustomerDiscount();
        }
    }
}
