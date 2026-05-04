package calculator;

import java.util.ArrayList;
import java.util.List;

import calculator.Token.TokenType;

public class Parser {

    public List<Token> parse(String input) {
        List<Token> tokens = new ArrayList<>();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input is empty");
        }

        input = input.replaceAll("\\s+", "");

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // מספר (כולל unary + / -)
            if (Character.isDigit(c) || isUnarySign(c, i, input)) {

                int sign = 1;

                if (c == '+' || c == '-') {
                    sign = (c == '-') ? -1 : 1;
                    i++;
                }

                if (i >= input.length() || !Character.isDigit(input.charAt(i))) {
                    throw new IllegalArgumentException("Invalid number format");
                }

                double num = 0;

                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    num = num * 10 + (input.charAt(i) - '0');
                    i++;
                }

                i--;

                tokens.add(new Token(TokenType.NUMBER, sign * num));
            }

            // אופרטור
            else if (isOperator(c)) {

                if (i == 0 || i == input.length() - 1 || isOperator(input.charAt(i - 1))) {
                    throw new IllegalArgumentException("Invalid operator sequence");
                }

                tokens.add(new Token(TokenType.OPERATOR, c));
            }

            else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        return tokens;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean isUnarySign(char c, int i, String input) {
        return (c == '+' || c == '-') &&
                (i == 0 || isOperator(input.charAt(i - 1)));
    }
}