package calculator;

import java.util.List;
import java.util.Stack;

import calculator.Token.TokenType;

public class Evaluator {

    public double evaluate(List<Token> tokens) {

        if (tokens == null || tokens.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression");
        }

        Stack<Double> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();

        try {
            for (Token token : tokens) {

                if (token.getType() == TokenType.NUMBER) {
                    numbers.push(token.getValue());
                }

                else if (token.getType() == TokenType.OPERATOR) {

                    char op = token.getOperator();

                    while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(op)) {
                        compute(numbers, ops);
                    }

                    ops.push(op);
                }
            }

            while (!ops.isEmpty()) {
                compute(numbers, ops);
            }

            if (numbers.size() != 1) {
                throw new IllegalArgumentException("Invalid expression");
            }

            return numbers.pop();

        } catch (ArithmeticException e) {
            throw e; // חשוב לטסט של חילוק באפס
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    private int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private void compute(Stack<Double> numbers, Stack<Character> ops) {

        if (numbers.size() < 2) {
            throw new IllegalArgumentException("Invalid expression");
        }

        double b = numbers.pop();
        double a = numbers.pop();
        char op = ops.pop();

        switch (op) {
            case '+':
                numbers.push(a + b);
                break;
            case '-':
                numbers.push(a - b);
                break;
            case '*':
                numbers.push(a * b);
                break;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                numbers.push(a / b);
                break;
        }
    }
}