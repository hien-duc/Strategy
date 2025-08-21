#!/bin/bash

# Run script for Strategy Pattern project

echo "Running Strategy Pattern Demo..."
echo "================================"

# Run the main demonstration
java -cp out vn.edu.eiu.strategy.Main

echo ""
echo "Running Unit Tests..."
echo "===================="

# Run the tests
java -cp out vn.edu.eiu.strategy.StrategyPatternTest
