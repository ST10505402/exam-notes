package templates.interfaces;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// JUnit 4 project instead: import org.junit.Test; import static org.junit.Assert.*;

/**
 * TEMPLATE: unit tests for an interface-implementing class.
 * Name each test EXACTLY as the paper's table; work out expected values by hand.
 */
public class ProductSalesTest {

    private final ProductSales calc = new ProductSales();
    private final int[][] sales = {
        {300, 250},
        {150, 200},
        {700, 600}
    };

    @Test
    public void TotalSales_ReturnsTotalSales() {
        assertEquals(2200, calc.TotalSales(sales));          // ints: no tolerance needed
    }

    @Test
    public void AverageSales_ReturnsAverage() {
        assertEquals(366.67, calc.AverageSales(sales), 0.01); // doubles: ALWAYS a tolerance
    }

    @Test
    public void MaxSale_ReturnsHighestValue() {
        assertEquals(700, calc.MaxSale(sales));
    }

    @Test
    public void TopProduct_ReturnsProductWithHighestTotal() {
        String[] products = {"Microphone", "Speakers", "Mixing Desk"};
        int[] totals = {550, 350, 1300};
        assertEquals("Mixing Desk", calc.TopProduct(products, totals));
    }

    @Test
    public void CountOverLimit_ReturnsNumberOverLimit() {
        assertEquals(2, calc.CountOverLimit(sales, 500));
    }

    @Test
    public void TotalSales_WrongValue_IsNotReturned() {
        assertNotEquals(9999, calc.TotalSales(sales));        // "calculated unsuccessfully" style
    }
}
