import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private static final double DELTA = 0.001;
    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        double result = calculator.calculate("1+2");
        assertEquals(3, result,DELTA);
    }
    @Test
    public void testSubset() {
        Calculator calculator = new Calculator();
        double result = calculator.calculate("1-2");
        assertEquals(-1, result,DELTA);
    }@Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        double result = calculator.calculate("2*3");
        assertEquals(6, result,DELTA);
    }@Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        double result = calculator.calculate("10/5");
        assertEquals(2, result,DELTA);
    }
}
