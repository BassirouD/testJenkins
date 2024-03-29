package urca.ufsen;

import org.junit.jupiter.api.Test;
import urca.ufsen.entities.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest2 {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }
}
