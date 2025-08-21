package vn.edu.eiu.strategy;

/**
 * Simple test class to verify Strategy pattern implementation
 *
 * This class demonstrates unit testing concepts for the Strategy pattern
 */
public class StrategyPatternTest {

    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Unit Tests ===\n");

        runAllTests();
    }

    public static void runAllTests() {
        testRegularCustomerDiscount();
        testPremiumMemberDiscount();
        testVipMemberDiscount();
        testHolidayPromotionDiscount();
        testBulkOrderDiscount();
        testShoppingCartStrategySwitch();

        System.out.println("All tests completed successfully! ✓");
    }

    private static void testRegularCustomerDiscount() {
        System.out.println("Testing RegularCustomerDiscount...");
        DiscountStrategy strategy = new RegularCustomerDiscount();
        double result = strategy.calculateDiscount(100.0);
        assert result == 100.0 : "Regular customer should have no discount";
        System.out.println("✓ RegularCustomerDiscount test passed\n");
    }

    private static void testPremiumMemberDiscount() {
        System.out.println("Testing PremiumMemberDiscount...");
        DiscountStrategy strategy = new PremiumMemberDiscount();
        double result = strategy.calculateDiscount(100.0);
        assert result == 90.0 : "Premium member should have 10% discount";
        System.out.println("✓ PremiumMemberDiscount test passed\n");
    }

    private static void testVipMemberDiscount() {
        System.out.println("Testing VipMemberDiscount...");
        DiscountStrategy strategy = new VipMemberDiscount();
        double result = strategy.calculateDiscount(100.0);
        assert result == 80.0 : "VIP member should have 20% discount";
        System.out.println("✓ VipMemberDiscount test passed\n");
    }

    private static void testHolidayPromotionDiscount() {
        System.out.println("Testing HolidayPromotionDiscount...");
        DiscountStrategy strategy = new HolidayPromotionDiscount();
        double result = strategy.calculateDiscount(100.0);
        assert result == 75.0 : "Holiday promotion should have 25% discount";
        System.out.println("✓ HolidayPromotionDiscount test passed\n");
    }

    private static void testBulkOrderDiscount() {
        System.out.println("Testing BulkOrderDiscount...");
        DiscountStrategy strategy = new BulkOrderDiscount();

        // Test bulk order (≥ $300)
        double result1 = strategy.calculateDiscount(500.0);
        assert result1 == 350.0 : "Bulk order should have 30% discount";

        // Test regular order (< $300)
        double result2 = strategy.calculateDiscount(200.0);
        assert result2 == 180.0 : "Regular order should have 10% discount";

        System.out.println("✓ BulkOrderDiscount test passed\n");
    }

    private static void testShoppingCartStrategySwitch() {
        System.out.println("Testing ShoppingCart strategy switching...");
        ShoppingCart cart = new ShoppingCart();

        // Test default strategy
        double result1 = cart.calculateTotal(100.0);
        assert result1 == 100.0 : "Default should be regular customer";

        // Test strategy switching
        cart.setDiscountStrategy(new PremiumMemberDiscount());
        double result2 = cart.calculateTotal(100.0);
        assert result2 == 90.0 : "Should apply premium member discount";

        System.out.println("✓ ShoppingCart strategy switching test passed\n");
    }
}
