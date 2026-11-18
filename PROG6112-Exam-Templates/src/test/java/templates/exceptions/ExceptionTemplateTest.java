package templates.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// JUnit 4 project instead: import org.junit.Test; import static org.junit.Assert.*;
// (assertThrows exists in JUnit 4.13+ and JUnit 5)

/**
 * TEMPLATE: testing that the right exception is thrown, and its message.
 */
public class ExceptionTemplateTest {

    @Test
    public void ParsePositive_ValidNumber_ReturnsValue() throws InvalidInputException {
        assertEquals(5, ExceptionTemplate.parsePositive(" 5 "));
    }

    @Test
    public void ParsePositive_Text_ThrowsInvalidInputException() {
        InvalidInputException ex = assertThrows(InvalidInputException.class,
                () -> ExceptionTemplate.parsePositive("abc"));
        assertTrue(ex.getMessage().contains("not a whole number"));
    }

    @Test
    public void ParsePositive_Negative_ThrowsInvalidInputException() {
        assertThrows(InvalidInputException.class, () -> ExceptionTemplate.parsePositive("-2"));
    }

    @Test
    public void Divide_ByZero_ThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> ExceptionTemplate.divide(10, 0));
    }

    @Test
    public void Divide_Normal_ReturnsDecimalResult() {
        assertEquals(2.5, ExceptionTemplate.divide(5, 2), 0.001);
    }
}
