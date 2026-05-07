package main.java.calculator;

import java.util.List;

public class Calculator {

    private Parser parser = new Parser();
    private Evaluator evaluator = new Evaluator();

    public double calculate(String input) {
        List<Token> tokens = parser.parse(input);
        return evaluator.evaluate(tokens);
    }
}