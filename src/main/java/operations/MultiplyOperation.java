package main.java.operations;

public class MultiplyOperation implements Operation {

    public double apply(double a, double b) {
        return a * b;
    }

    public char symbol() {
        return '*';
    }
}
