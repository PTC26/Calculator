package calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        Calculator calc = new Calculator();

        int result = calc.calculate("1+2");

        assertEquals(3, result);
    }


    @Test
    void shouldSubtractTwoNumbers() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.calculate("3-2"));
    }

    @Test
    void shouldMultiplyTwoNumbers() {
        Calculator calc = new Calculator();
        assertEquals(6, calc.calculate("2*3"));
    }

    @Test
    void shouldDivideTwoNumbers() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.calculate("4/2"));
    }

    @Test
    void shouldIgnoreSpaces() {
        Calculator calc = new Calculator();
        assertEquals(4, calc.calculate(" 1 + 2 + 1 "));
    }
    @Test
    void shouldRespectPrecedence() {
        Calculator calc = new Calculator();
        assertEquals(13, calc.calculate("1 + 2 * 6"));
    }

    @Test
    void shouldRespectPrecedenceWithDivision() {
        Calculator calc = new Calculator();
        assertEquals(7, calc.calculate("8 / 2 + 3"));
    }
    @Test
    void shouldHandleNegativeNumbers() {
        Calculator calc = new Calculator();
        assertEquals(-1, calc.calculate("2 + -3"));
    }

    @Test
    void shouldMultiplyNegativeNumbers() {
        Calculator calc = new Calculator();
        assertEquals(-6, calc.calculate("2 * -3"));
    }
    @Test
    void shouldHandleUnaryPlus() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.calculate("2 * +3"));
    }
    @Test
    void shouldHandleMixedExpression() {
        Calculator calc = new Calculator();
        assertEquals(9, calc.calculate("2 + 3 * 2 + 1"));
    }

    @Test
    void shouldHandleNegativeAndPrecedence() {
        Calculator calc = new Calculator();
        assertEquals(-4, calc.calculate("2 + -3 * 2"));
    }

    @Test
    void shouldThrowExceptionOnDivisionByZero() {
        Calculator calc = new Calculator();

        assertThrows(ArithmeticException.class, () -> {
            calc.calculate("8/0");
        });
    }

        @Test
        void shouldThrowExceptionOnDoubleOperators() {
            Calculator calc = new Calculator();

            assertThrows(IllegalArgumentException.class, () -> {
                calc.calculate("5*/3");
            });
        }

        @Test
        void shouldThrowExceptionOnInvalidExpression() {
            Calculator calc = new Calculator();

            assertThrows(IllegalArgumentException.class, () -> {
                calc.calculate("5**3");
            });
        }


    @Test
    void shouldHandleSingleNumber() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.calculate("5"));
    }

    @Test
    void shouldHandleZeroOperations() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.calculate("0+0*5"));
    }

    }