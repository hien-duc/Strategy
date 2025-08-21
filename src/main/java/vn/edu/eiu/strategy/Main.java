package vn.edu.eiu.strategy;

import java.util.Scanner;

/**
 * Strategy Pattern Implementation - E-commerce Discount System
 *
 * This demonstrates the Strategy pattern by implementing different discount strategies
 * that can be applied to customer orders based on their membership type or promotions.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Demo: E-commerce Discount System ===\n");

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Demo with different discount strategies
        demonstrateStrategies(cart);

        // Advanced features demonstration
        StrategyPatternDemo.demonstrateAdvancedFeatures();

        // Best discount finder
        demonstrateBestDiscountFinder();

        // Interactive demo
        interactiveDemo(cart);
    }

    /**
     * Demonstrates different discount strategies with predefined scenarios
     */
    private static void demonstrateStrategies(ShoppingCart cart) {
        double orderAmount = 1000.0;

        System.out.println("Order Amount: $" + orderAmount);
        System.out.println("Testing different discount strategies:\n");

        // Regular customer (no discount)
        cart.setDiscountStrategy(new RegularCustomerDiscount());
        System.out.println("1. Regular Customer:");
        System.out.println("   Final Amount: $" + cart.calculateTotal(orderAmount));

        // Premium member (10% discount)
        cart.setDiscountStrategy(new PremiumMemberDiscount());
        System.out.println("\n2. Premium Member:");
        System.out.println("   Final Amount: $" + cart.calculateTotal(orderAmount));

        // VIP member (20% discount)
        cart.setDiscountStrategy(new VipMemberDiscount());
        System.out.println("\n3. VIP Member:");
        System.out.println("   Final Amount: $" + cart.calculateTotal(orderAmount));

        // Holiday promotion (25% discount)
        cart.setDiscountStrategy(new HolidayPromotionDiscount());
        System.out.println("\n4. Holiday Promotion:");
        System.out.println("   Final Amount: $" + cart.calculateTotal(orderAmount));

        System.out.println("\n" + "=".repeat(50) + "\n");
    }

    /**
     * Interactive demo allowing user to choose discount strategy
     */
    private static void interactiveDemo(ShoppingCart cart) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Interactive Demo - Choose your discount strategy:");
        System.out.print("Enter order amount: $");
        double amount = scanner.nextDouble();

        System.out.println("\nSelect discount strategy:");
        System.out.println("1. Regular Customer (0% discount)");
        System.out.println("2. Premium Member (10% discount)");
        System.out.println("3. VIP Member (20% discount)");
        System.out.println("4. Holiday Promotion (25% discount)");
        System.out.print("Enter choice (1-4): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                cart.setDiscountStrategy(new RegularCustomerDiscount());
                break;
            case 2:
                cart.setDiscountStrategy(new PremiumMemberDiscount());
                break;
            case 3:
                cart.setDiscountStrategy(new VipMemberDiscount());
                break;
            case 4:
                cart.setDiscountStrategy(new HolidayPromotionDiscount());
                break;
            default:
                System.out.println("Invalid choice, using Regular Customer discount");
                cart.setDiscountStrategy(new RegularCustomerDiscount());
        }

        double finalAmount = cart.calculateTotal(amount);
        System.out.println("\nOrder Summary:");
        System.out.println("Original Amount: $" + amount);
        System.out.println("Final Amount: $" + finalAmount);
        System.out.println("You saved: $" + (amount - finalAmount));

        scanner.close();
    }

    /**
     * Demonstrates the discount calculator that finds the best available discount
     */
    private static void demonstrateBestDiscountFinder() {
        System.out.println("=== Best Discount Finder Demo ===\n");

        DiscountCalculator calculator = new DiscountCalculator();
        double testAmount = 750.0;

        DiscountCalculator.DiscountResult result = calculator.findBestDiscount(testAmount);
        System.out.println(result);
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}
