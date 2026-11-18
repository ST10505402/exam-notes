package memos.practice2026.q2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Practice 2026 Q2.5 - unit tests named exactly as the paper's table.
 */
public class SurfSalesTest {

    private final SurfSales surfSales = new SurfSales();

    @Test
    public void GetSalesOverTarget_ReturnsNumberOfSales() {
        assertEquals(3, surfSales.GetSalesOverTarget());    // 520, 610, 450
    }

    @Test
    public void GetSalesUnderTarget_ReturnsNumberOfSales() {
        assertEquals(6, surfSales.GetSalesUnderTarget());   // 380, 150, 340, 210, 290, 200
    }

    @Test
    public void GetYearsProcessed_ReturnsNumberOfRows() {
        assertEquals(3, surfSales.GetYearsProcessed());
    }
}
