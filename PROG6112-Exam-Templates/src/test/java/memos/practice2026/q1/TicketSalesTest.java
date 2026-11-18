package memos.practice2026.q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Practice 2026 Q1.3 - unit tests named exactly as the paper's table.
 */
public class TicketSalesTest {

    private final TicketSales sales = new TicketSales();
    private final int[][] ticketSales = {
        {420, 310, 180, 390},
        {450, 280, 220, 390}
    };

    @Test
    public void CalculateTotalTicketSales_ReturnsTotalTicketSales() {
        assertEquals(2640, sales.TotalTicketSales(ticketSales));
    }

    @Test
    public void AverageTicketSales_ReturnsAverageTicketSales() {
        assertEquals(330.0, sales.AverageTicketSales(ticketSales), 0.01);   // 2640 / 8
    }
}
