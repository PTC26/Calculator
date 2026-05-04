package calculator.operations;

public interface Operation {
    double apply(double a, double b);
    char symbol();
}