package memos.mock2.q2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Mock 2 Q2.9 - the four required tests, plus extra validation checks.
 */
public class RegistrationTest {

    private final Registration registration = new Registration();

    @Test
    public void CalculateSubtotal_TwoDaysWithWorkshop_ReturnsCorrectSubtotal() {
        // Student: 50 x 2 days + 100 workshop = 200
        assertEquals(200.0, registration.CalculateSubtotal("Student", 2, true), 0.01);
    }

    @Test
    public void CalculateDiscount_StudentTicket_ReturnsTwentyPercent() {
        assertEquals(40.0, registration.CalculateDiscount("Student", 200.0), 0.01);
    }

    @Test
    public void ValidateEmail_MissingAtSymbol_ReturnsFalse() {
        assertFalse(registration.ValidateEmail("lerato.gmail.com"));
    }

    @Test
    public void CountWords_ReturnsNumberOfWords() {
        assertEquals(5, registration.CountWords("  I   want to learn   Java "));
    }

    // ---- extra checks (not required by the paper) ----

    @Test
    public void CalculateDiscount_StandardTicket_ReturnsZero() {
        assertEquals(0.0, registration.CalculateDiscount("Standard", 150.0), 0.01);
    }

    @Test
    public void CalculateSubtotal_VipTwoDaysWithWorkshop_Returns900() {
        assertEquals(900.0, registration.CalculateSubtotal("VIP", 2, true), 0.01);
    }

    @Test
    public void ValidateEmail_ValidAddress_ReturnsTrue() {
        assertTrue(registration.ValidateEmail("lerato@gmail.com"));
    }

    @Test
    public void ValidateEmail_TwoAtSymbols_ReturnsFalse() {
        assertFalse(registration.ValidateEmail("a@b@c.com"));
    }

    @Test
    public void ValidateData_SelectTicket_ReturnsFalse() {
        RegistrationData data = new RegistrationData("Lerato", "Mokoena", "lerato@gmail.com",
                "-- Select --", 2, true, "I want to learn about new tech");
        assertFalse(registration.ValidateData(data));
    }

    @Test
    public void ValidateData_ValidRegistration_ReturnsTrue() {
        RegistrationData data = new RegistrationData("Lerato", "Mokoena", "lerato@gmail.com",
                "Student", 2, true, "I want to learn about new tech");
        assertTrue(registration.ValidateData(data));
    }
}
