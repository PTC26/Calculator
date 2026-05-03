package calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    }