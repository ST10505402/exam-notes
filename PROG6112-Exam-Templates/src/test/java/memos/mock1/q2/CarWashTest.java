package memos.mock1.q2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the CarWash class.
 */
public class CarWashTest {

    private final CarWash carWash = new CarWash();

    @Test
    public void CalculateSubtotal_WithTyreShine_ReturnsCorrectSubtotal() {
        // (150 + 25) x 3 = 525.00
        double subtotal = carWash.CalculateSubtotal("Full", 3, true);
        assertEquals(525.00, subtotal, 0.01);
    }

    @Test
    public void CalculateDiscount_ThreeOrMoreVehicles_ReturnsTenPercent() {
        // 10% of 525.00 = 52.50
        double discount = carWash.CalculateDiscount(525.00, 3);
        assertEquals(52.50, discount, 0.01);
    }

    @Test
    public void ValidateData_InvalidNumberOfVehicles_ReturnsFalse() {
        // 0 vehicles breaks the 1-10 rule
        BookingData booking = new BookingData("Lerato", "Full", 0);
        assertFalse(carWash.ValidateData(booking));
    }
}
