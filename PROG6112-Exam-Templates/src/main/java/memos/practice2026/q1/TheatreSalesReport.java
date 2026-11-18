package memos.practice2026.q1;

/**
 * Practice 2026 Q1.1 - Harbourlight Theatre ticket sales report.
 */
public class TheatreSalesReport {

    public static void main(String[] args) {
        // Single arrays: season names (columns) and years (rows)
        String[] seasons = {"SUMMER", "AUTUMN", "WINTER", "SPRING"};
        String[] years = {"YEAR 1", "YEAR 2"};

        // 2D array: [year][season]
        int[][] ticketSales = {
            {420, 310, 180, 390},
            {450, 280, 220, 390}
        };

        TicketSales sales = new TicketSales();
        String line = "-".repeat(46);

        System.out.println("THEATRE TICKET SALES REPORT - 2026");
        System.out.println(line);

        // Column headings
        System.out.printf("%-10s", "");
        for (String season : seasons) {
            System.out.printf("%-9s", season);
        }
        System.out.println();

        // Rows
        for (int row = 0; row < ticketSales.length; row++) {
            System.out.printf("%-10s", years[row]);
            for (int col = 0; col < ticketSales[row].length; col++) {
                System.out.printf("%-9d", ticketSales[row][col]);
            }
            System.out.println();
        }
        System.out.println(line);

        // Summary; average rounded to the nearest whole number
        System.out.println("Total tickets sold:   " + sales.TotalTicketSales(ticketSales));
        System.out.println("Average per season:   " + Math.round(sales.AverageTicketSales(ticketSales)));
        System.out.println("Highest season:       " + sales.HighestSale(ticketSales));
        System.out.println("Lowest season:        " + sales.LowestSale(ticketSales));
        System.out.println(line);
    }
}
