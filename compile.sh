#!/bin/bash

# Compilation script for Strategy Pattern project

echo "Compiling Strategy Pattern implementation..."

# Create output directory
mkdir -p out

# Compile all Java files
javac -d out src/main/java/vn/edu/eiu/strategy/*.java

if [ $? -eq 0 ]; then
    echo "✓ Compilation successful!"
    echo ""
    echo "To run the main demo:"
    echo "java -cp out vn.edu.eiu.strategy.Main"
    echo ""
    echo "To run the tests:"
    echo "java -cp out vn.edu.eiu.strategy.StrategyPatternTest"
else
    echo "✗ Compilation failed!"
fi
