package main.java.operations;

public class DivideOperation implements Operation {

    public double apply(double a, double b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }

    public char symbol() {
        return '/';
    }
}