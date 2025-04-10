package calculatorlab5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NewIntCalculatorTest {

    @Test
    public void testadd() {
        NewIntCalculator calc = new NewIntCalculator(10);

        calc.add(5);

        assertEquals(15, calc.result());
    }

    @Test
    public void testsubstract() {
        NewIntCalculator calc = new NewIntCalculator(10);

        calc.subtract(5);

        assertEquals(5, calc.result());
    }

    @Test
    public void testmultiply() {
        NewIntCalculator calc = new NewIntCalculator(10);

        calc.multiply(5);

        assertEquals(50, calc.result());
    }

    @Test
    public void testInitWithValidInteger() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(0);

        // Act
        calc.init(42);

        // Assert
        assertEquals(42, calc.result());
    }

    @Test
    public void testInitWithInvalidType() {
        // Arrange
        NewIntCalculator calc = new NewIntCalculator(0);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> calc.init("invalid"));
    }
}
