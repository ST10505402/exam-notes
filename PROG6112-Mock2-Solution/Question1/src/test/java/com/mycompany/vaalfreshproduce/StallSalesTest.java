package com.mycompany.vaalfreshproduce;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Q.1.3 - unit tests named exactly as the paper's table, plus two extra checks.
 */
public class StallSalesTest {

    private final StallSales stallSales = new StallSales();
    private final String[] products = {"Tomatoes", "Spinach", "Potatoes"};
    private final int[][] data = {
        {120, 95, 80, 140},
        {60, 75, 90, 55},
        {200, 180, 160, 210}
    };

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        assertEquals(1465, stallSales.TotalSales(data));     // 435 + 280 + 750
    }

    @Test
    public void TopProduct_ReturnsTopSellingProduct() {
        assertEquals("Potatoes", stallSales.TopProduct(products, data));
    }

    // Extra: proves TopProduct compares TOTALS, not the biggest single quarter
    @Test
    public void TopProduct_BiggestSingleQuarterIsNotTopProduct_ReturnsHighestTotal() {
        int[][] changed = {
            {120, 95, 80, 300},    // biggest single quarter, but total only 595
            {60, 75, 90, 55},
            {200, 180, 160, 210}   // total 750
        };
        assertEquals("Potatoes", stallSales.TopProduct(products, changed));
    }

    // Extra: proves there is no integer division
    @Test
    public void AverageSales_ReturnsUnroundedAverage() {
        assertEquals(122.08, stallSales.AverageSales(data), 0.01);   // 1465 / 12
    }
}
