package urca.ufsen;
import org.junit.jupiter.api.Test;
import urca.ufsen.entities.Calculator;
import urca.ufsen.entities.MathUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CalculatorTest2 {
    @Test
    public void testAdd() {
        int result = MathUtils.add(2, 3);
        assertEquals(0, result);
    }
    @Test
    public void testSubtract() {
        int result = MathUtils.subtract(5, 3);
        assertEquals(2, result);
    }
    @Test
    public void testCalculatorAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }
    @Test
    public void testCalculatorSubtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }
}
