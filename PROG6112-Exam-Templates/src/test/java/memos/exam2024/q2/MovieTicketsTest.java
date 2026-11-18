package memos.exam2024.q2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 2024 Q2.9 - calculation test + one validation test (extra validation tests shown too).
 */
public class MovieTicketsTest {

    private final MovieTickets movieTickets = new MovieTickets();

    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        // 3 x 100 = 300, + 14% VAT = 342.00
        assertEquals(342.00, movieTickets.CalculateTotalTicketPrice(3, 100), 0.01);
    }

    @Test
    public void ValidateData_InvalidTicketPrice_ReturnsFalse() {
        assertFalse(movieTickets.ValidateData(new MovieTicketData("Napoleon", 3, 0)));
    }

    @Test
    public void ValidateData_InvalidNumberOfTickets_ReturnsFalse() {
        assertFalse(movieTickets.ValidateData(new MovieTicketData("Napoleon", 0, 100)));
    }

    @Test
    public void ValidateData_EmptyMovieName_ReturnsFalse() {
        assertFalse(movieTickets.ValidateData(new MovieTicketData("", 3, 100)));
    }

    @Test
    public void ValidateData_ValidData_ReturnsTrue() {
        assertTrue(movieTickets.ValidateData(new MovieTicketData("Napoleon", 3, 100)));
    }
}
