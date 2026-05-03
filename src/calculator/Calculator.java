package calculator;

import java.util.Stack;

public class Calculator {

    public int calculate(String input) {
        input = input.replaceAll("\\s+", "");

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // number or unary +/-
            if (Character.isDigit(c) || isUnarySign(c, i, input)) {

                int sign = 1;

                if (c == '+' || c == '-') {
                    sign = (c == '-') ? -1 : 1;
                    i++; // move to digit
                }

                int num = 0;
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    num = num * 10 + (input.charAt(i) - '0');
                    i++;
                }
                i--;

                numbers.push(sign * num);
            }

            // operator
            else if (isOperator(c)) {

                // ❗ validation: no two operators in a row
                if (i == 0 || i == input.length() - 1 || isOperator(input.charAt(i - 1))) {
                    throw new IllegalArgumentException("Invalid operator sequence");
                }

                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    compute(numbers, ops);
                }

                ops.push(c);
            }

            else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        while (!ops.isEmpty()) {
            compute(numbers, ops);
        }

        return numbers.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isUnarySign(char c, int i, String input) {
        return (c == '+' || c == '-') &&
                (i == 0 || isOperator(input.charAt(i - 1)));
    }

    private int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private void compute(Stack<Integer> numbers, Stack<Character> ops) {
        if (numbers.size() < 2)
            throw new IllegalArgumentException("Invalid expression");

        int b = numbers.pop();
        int a = numbers.pop();
        char op = ops.pop();

        switch (op) {
            case '+': numbers.push(a + b); break;
            case '-': numbers.push(a - b); break;
            case '*': numbers.push(a * b); break;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                numbers.push(a / b);
                break;
        }
    }
}