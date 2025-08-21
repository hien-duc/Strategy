package vn.edu.eiu.strategy;

/**
 * Strategy Interface - Defines the contract for discount calculation algorithms
 *
 * This interface represents the Strategy in the Strategy pattern.
 * All concrete discount strategies must implement this interface.
 */
public interface DiscountStrategy {

    /**
     * Calculates the final amount after applying the discount
     *
     * @param originalAmount The original order amount before discount
     * @return The final amount after applying the discount
     */
    double calculateDiscount(double originalAmount);

    /**
     * Gets the description of this discount strategy
     *
     * @return A string describing the discount strategy
     */
    String getDescription();
}
