package memos.exam2025.q2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 2025 Q2.5 - unit tests named exactly as the paper's table.
 */
public class ProductSalesTest {

    private final ProductSales productSales = new ProductSales();

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        assertEquals(2, productSales.GetSalesOverLimit());    // 700 and 600
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        assertEquals(4, productSales.GetSalesUnderLimit());   // 300, 150, 250, 200
    }

    @Test
    public void GetProductsProcessed_ReturnsNumberOfYears() {
        assertEquals(2, productSales.GetProductsProcessed());
    }
}
