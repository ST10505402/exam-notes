package memos.exam2024.q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 2024 Q1.3 - unit tests named exactly as the paper's table.
 */
public class MovieTicketsTest {

    private final MovieTickets movieTickets = new MovieTickets();

    @Test
    public void CalculateTotalSales_ReturnsExpectedTotalSales() {
        int[] napoleonSales = {3000, 1500, 1700};               // 3000 + 1500 + 1700 = 6200
        assertEquals(6200, movieTickets.TotalMovieSales(napoleonSales));
    }

    @Test
    public void TopMovieSales_ReturnsTopMovie() {
        String[] movies = {"Napoleon", "Oppenheimer"};
        int[] totals = {6200, 6300};
        assertEquals("Oppenheimer", movieTickets.TopMovie(movies, totals));
    }
}
