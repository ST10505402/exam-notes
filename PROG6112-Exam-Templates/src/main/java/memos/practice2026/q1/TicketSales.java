package memos.practice2026.q1;

/**
 * Practice 2026 Q1.2 - total, average, highest and lowest season sales.
 */
public class TicketSales implements ITicketSales {

    // Sum of every season's sales
    @Override
    public int TotalTicketSales(int[][] ticketSales) {
        int total = 0;
        for (int row = 0; row < ticketSales.length; row++) {
            for (int col = 0; col < ticketSales[row].length; col++) {
                total += ticketSales[row][col];
            }
        }
        return total;
    }

    // Average per season (cast to avoid integer division)
    @Override
    public double AverageTicketSales(int[][] ticketSales) {
        int count = 0;
        for (int[] year : ticketSales) {
            count += year.length;
        }
        return count == 0 ? 0 : (double) TotalTicketSales(ticketSales) / count;
    }

    // Highest single season
    @Override
    public int HighestSale(int[][] ticketSales) {
        int highest = ticketSales[0][0];
        for (int[] year : ticketSales) {
            for (int sale : year) {
                if (sale > highest) {
                    highest = sale;
                }
            }
        }
        return highest;
    }

    // Lowest single season
    @Override
    public int LowestSale(int[][] ticketSales) {
        int lowest = ticketSales[0][0];
        for (int[] year : ticketSales) {
            for (int sale : year) {
                if (sale < lowest) {
                    lowest = sale;
                }
            }
        }
        return lowest;
    }
}
