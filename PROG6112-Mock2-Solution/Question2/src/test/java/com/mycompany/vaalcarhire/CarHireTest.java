package com.mycompany.vaalcarhire;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Q.2.9 - the required calculation test and one validation test, plus extra checks.
 */
public class CarHireTest {

    private final CarHire carHire = new CarHire();

    @Test
    public void CalculateRentalCost_SevenDaysOrMore_AppliesDiscount() {
        // Sedan: 500 x 7 = 3500, less 10% = 3150
        assertEquals(3150.00, carHire.CalculateRentalCost("Sedan", 7), 0.01);
    }

    @Test
    public void ValidateData_EmptyCustomerName_ReturnsFalse() {
        assertFalse(carHire.ValidateData(new RentalData("", "Sedan", 7)));
    }

    // ---- extra checks (not required by the paper) ----

    @Test
    public void CalculateRentalCost_UnderSevenDays_NoDiscount() {
        assertEquals(1050.00, carHire.CalculateRentalCost("Hatchback", 3), 0.01);
    }

    @Test
    public void ValidateData_ThirtyOneDays_ReturnsFalse() {
        assertFalse(carHire.ValidateData(new RentalData("Thabo Nkosi", "SUV", 31)));
    }

    @Test
    public void ValidateData_ZeroDays_ReturnsFalse() {
        assertFalse(carHire.ValidateData(new RentalData("Thabo Nkosi", "SUV", 0)));
    }

    @Test
    public void ValidateData_ValidRental_ReturnsTrue() {
        assertTrue(carHire.ValidateData(new RentalData("Thabo Nkosi", "Sedan", 7)));
    }
}
