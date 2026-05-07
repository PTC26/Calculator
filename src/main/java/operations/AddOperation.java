package main.java.operations;

public class AddOperation implements Operation {

    public double apply(double a, double b) {
        return a + b;
    }

    public char symbol() {
        return '+';
    }
}
