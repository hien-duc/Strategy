package vn.edu.eiu.strategy;

/**
 * Context Class - Shopping Cart
 *
 * This class represents the Context in the Strategy pattern.
 * It maintains a reference to a Strategy object and delegates
 * the discount calculation to the current strategy.
 */
public class ShoppingCart {

    private DiscountStrategy discountStrategy;

    /**
     * Constructor with default strategy
     */
    public ShoppingCart() {
        // Default to regular customer discount (no discount)
        this.discountStrategy = new RegularCustomerDiscount();
    }

    /**
     * Constructor with specified strategy
     *
     * @param discountStrategy The discount strategy to use
     */
    public ShoppingCart(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Sets the discount strategy at runtime
     *
     * @param discountStrategy The new discount strategy to use
     */
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
        System.out.println("Strategy changed to: " + discountStrategy.getDescription());
    }

    /**
     * Calculates the total amount after applying the current discount strategy
     *
     * @param originalAmount The original order amount
     * @return The final amount after discount
     */
    public double calculateTotal(double originalAmount) {
        if (discountStrategy == null) {
            throw new IllegalStateException("Discount strategy not set");
        }

        return discountStrategy.calculateDiscount(originalAmount);
    }

    /**
     * Gets the current discount strategy description
     *
     * @return Description of the current strategy
     */
    public String getCurrentStrategyDescription() {
        return discountStrategy != null ? discountStrategy.getDescription() : "No strategy set";
    }
}
