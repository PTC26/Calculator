package main.java.calculator;

public class Token {

    public enum TokenType {
        NUMBER,
        OPERATOR
    }

    private TokenType type;
    private double value;
    private char operator;

    public Token(TokenType type, double value) {
        this.type = type;
        this.value = value;
    }

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