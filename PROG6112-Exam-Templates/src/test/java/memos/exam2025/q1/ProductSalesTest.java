package memos.exam2025.q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 2025 Q1.3 - unit tests named exactly as the paper's table.
 */
public class ProductSalesTest {

    private final ProductSales sales = new ProductSales();
    private final int[][] productSales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        assertEquals(2200, sales.TotalSales(productSales));
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        assertEquals(366.67, sales.AverageSales(productSales), 0.01);   // 2200 / 6
    }
}
