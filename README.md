# Strategy Pattern Implementation - E-commerce Discount System

## Overview
This project demonstrates the **Strategy Design Pattern** through an e-commerce discount system. The implementation shows how different discount algorithms can be encapsulated and made interchangeable at runtime.

## Pattern Structure

### Components
1. **Strategy Interface** (`DiscountStrategy`)
   - Defines the contract for all discount algorithms
   - Contains methods: `calculateDiscount()` and `getDescription()`

2. **Concrete Strategies**
   - `RegularCustomerDiscount` - No discount (0%)
   - `PremiumMemberDiscount` - 10% discount
   - `VipMemberDiscount` - 20% discount
   - `HolidayPromotionDiscount` - 25% discount
   - `BulkOrderDiscount` - Conditional discount (30% for orders ≥ $300, otherwise 10%)

3. **Context Class** (`ShoppingCart`)
   - Maintains reference to current strategy
   - Delegates discount calculation to the strategy
   - Allows strategy switching at runtime

## Key Features

### Basic Implementation
- Multiple discount strategies for different customer types
- Runtime strategy switching
- Clean separation of concerns

### Advanced Features
- **Dynamic Strategy Selection** - Automatically chooses best strategy based on order amount
- **Strategy Comparison** - `DiscountCalculator` compares all strategies to find the best discount
- **Lambda Expression Support** - Demonstrates modern Java 8+ features
- **Interactive Demo** - Console-based user interface for testing

## Real-World Applications

The Strategy pattern is commonly used in:
- **Payment Processing** - Different payment methods (Credit Card, PayPal, Bank Transfer)
- **Sorting Algorithms** - Different sorting strategies (QuickSort, MergeSort, BubbleSort)
- **Compression** - Different compression algorithms (ZIP, RAR, 7Z)
- **Navigation Systems** - Route calculation strategies (Fastest, Shortest, Scenic)
- **Game AI** - Different behavior strategies for NPCs

## Benefits

1. **Open/Closed Principle** - Open for extension, closed for modification
2. **Runtime Flexibility** - Strategies can be changed during execution
3. **Code Reusability** - Strategies can be reused across different contexts
4. **Eliminates Conditionals** - Replaces complex if-else chains
5. **Easy Testing** - Each strategy can be tested independently

## How to Run

1. Compile all Java files:
   ```bash
   javac src/main/java/vn/edu/eiu/strategy/*.java
   ```

2. Run the main class:
   ```bash
   java -cp src/main/java vn.edu.eiu.strategy.Main
   ```

## Project Structure
```
src/main/java/vn/edu/eiu/strategy/
├── Main.java                      # Main demonstration class
├── DiscountStrategy.java          # Strategy interface
├── ShoppingCart.java              # Context class
├── RegularCustomerDiscount.java   # Concrete strategy
├── PremiumMemberDiscount.java     # Concrete strategy
├── VipMemberDiscount.java         # Concrete strategy
├── HolidayPromotionDiscount.java  # Concrete strategy
├── BulkOrderDiscount.java         # Concrete strategy
├── StrategyPatternDemo.java       # Advanced features demo
└── DiscountCalculator.java        # Utility for strategy comparison
```

## Sample Output
```
=== Strategy Pattern Demo: E-commerce Discount System ===

Order Amount: $1000.0
Testing different discount strategies:

1. Regular Customer:
   Strategy changed to: Regular Customer - No discount applied
   Applying Regular Customer discount: 0%
   Final Amount: $1000.0

2. Premium Member:
   Strategy changed to: Premium Member - 10% discount on all purchases
   Applying Premium Member discount: 10%
   Discount amount: $100.0
   Final Amount: $900.0
```

## Design Principles Demonstrated

- **Single Responsibility Principle** - Each strategy has one reason to change
- **Open/Closed Principle** - Easy to add new strategies without modifying existing code
- **Dependency Inversion Principle** - Context depends on abstraction, not concrete classes
- **Composition over Inheritance** - Uses composition to achieve flexibility

## Extension Points

The implementation can be easily extended with:
- New discount strategies (e.g., `FirstTimeCustomerDiscount`, `LoyaltyPointsDiscount`)
- Complex discount rules (e.g., category-based discounts, time-based promotions)
- Strategy persistence and configuration
- Integration with external pricing systems
