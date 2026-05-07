package main.java.calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Token> parse(String input) {

        List<Token> tokens = new ArrayList<>();

        // בדיקה שהקלט לא ריק
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input is empty");
        }

        // מוחק רווחים מהביטוי
        input = input.replaceAll("\\s+", "");

        // מעבר על כל התווים בביטוי
        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            // מספר (כולל unary + / -)
            if (Character.isDigit(c) || isUnarySign(c, i, input)) {

                int sign = 1;

                // טיפול ב־+ או - בתחילת מספר
                if (c == '+' || c == '-') {

                    sign = (c == '-') ? -1 : 1;

                    i++;
                }

                // בדיקה שיש באמת מספר אחרי הסימן
                if (i >= input.length() ||
                        (!Character.isDigit(input.charAt(i)) &&
                                input.charAt(i) != '.')) {

                    throw new IllegalArgumentException("Invalid number format");
                }

                // בונה את המספר כמחרוזת
                StringBuilder number = new StringBuilder();

                // זוכר אם כבר הייתה נקודה
                boolean hasDot = false;

                // קריאת המספר
                while (i < input.length() &&
                        (Character.isDigit(input.charAt(i))
                                || input.charAt(i) == '.')) {

                    // אם מצאנו נקודה
                    if (input.charAt(i) == '.') {

                        // אם כבר הייתה נקודה → שגיאה
                        if (hasDot) {
                            throw new IllegalArgumentException("Invalid decimal number");
                        }

                        hasDot = true;
                    }

                    // מוסיף את התו למספר
                    number.append(input.charAt(i));

                    i++;
                }

                // חוזרים צעד אחורה כי הלולאה הגדילה i פעם אחת יותר מדי
                i--;

                // המרה מ־String ל־double
                double num = Double.parseDouble(number.toString());

                // מוסיף Token מסוג NUMBER
                tokens.add(
                        new Token(
                                Token.TokenType.NUMBER,
                                sign * num
                        )
                );
            }

            // אופרטור
            else if (isOperator(c)) {

                // בדיקות תקינות
                if (i == 0 ||
                        i == input.length() - 1 ||
                        isOperator(input.charAt(i - 1))) {

                    throw new IllegalArgumentException("Invalid operator sequence");
                }

                // מוסיף Token של אופרטור
                tokens.add(
                        new Token(
                                Token.TokenType.OPERATOR,
                                c
                        )
                );
            }

            // תו לא חוקי
            else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        return tokens;
    }

    // בודק אם זה אופרטור
    private boolean isOperator(char c) {

        return c == '+'
                || c == '-'
                || c == '*'
                || c == '/';
    }

    // בודק אם זה unary +/-
    private boolean isUnarySign(char c, int i, String input) {

        return (c == '+' || c == '-')
                &&
                (i == 0 || isOperator(input.charAt(i - 1)));
    }
}