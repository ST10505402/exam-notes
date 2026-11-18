package templates.gui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// JUnit 4 project instead: import org.junit.Test; import static org.junit.Assert.*;

/**
 * TEMPLATE: unit tests for calculation + validation.
 */
public class MovieTicketsTest {

    private final MovieTickets logic = new MovieTickets();

    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        // 2 x 100 = 200, + 15% VAT = 230.00
        assertEquals(230.00, logic.CalculateTotalTicketPrice(2, 100), 0.01);
    }

    @Test
    public void ValidateData_ValidInput_ReturnsTrue() {
        assertTrue(logic.ValidateData(new TicketData("Damsel", 2, 100)));
    }

    @Test
    public void ValidateData_EmptyMovieName_ReturnsFalse() {
        assertFalse(logic.ValidateData(new TicketData("", 2, 100)));
    }

    @Test
    public void ValidateData_ZeroTickets_ReturnsFalse() {
        assertFalse(logic.ValidateData(new TicketData("Damsel", 0, 100)));
    }

    @Test
    public void ValidateData_ZeroPrice_ReturnsFalse() {
        assertFalse(logic.ValidateData(new TicketData("Damsel", 2, 0)));
    }
}
