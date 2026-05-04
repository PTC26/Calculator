package calculator;

public class Token {

    public enum TokenType {
        NUMBER,
        OPERATOR
    }

    private TokenType type;
    private double value;
    private char operator;

    // מספר
    public Token(TokenType type, double value) {
        this.type = type;
        this.value = value;
    }

    // אופרטור
    public Token(TokenType type, char operator) {
        this.type = type;
        this.operator = operator;
    }

    public TokenType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public char getOperator() {
        return operator;
    }
}