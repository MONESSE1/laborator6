package calculatorlab5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DoubleCalculatorTest {

    @Test
    public void testAdd() {

        DoubleCalculator calc = new DoubleCalculator(5.0);
        calc.add(2.5);
        assertEquals(7.5, (Double) calc.result(), 0.0001);
    }

    @Test
    public void testSubtract() {
        DoubleCalculator calc = new DoubleCalculator(10.0);
        calc.subtract(3.5);
        assertEquals(6.5, (Double) calc.result(), 0.0001);
    }

    @Test
    public void testMultiply() {

        DoubleCalculator calc = new DoubleCalculator(3.0);
        calc.multiply(2.5);
        assertEquals(7.5, (Double) calc.result(), 0.0001);
    }

    @Test
    public void testInitWithValidDouble() {

        DoubleCalculator calc = new DoubleCalculator(0.0);
        calc.init(8.75);
        assertEquals(8.75, (double) calc.result(), 0.0001);
    }

    @Test
    public void testInitWithInvalidType() {
        DoubleCalculator calc = new DoubleCalculator(0.0);
        assertThrows(IllegalArgumentException.class, () -> calc.init(123));
    }
}
