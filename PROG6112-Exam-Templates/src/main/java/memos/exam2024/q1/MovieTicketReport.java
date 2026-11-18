package memos.exam2024.q1;

/**
 * 2024 Q1.1 - prints the movie ticket sales report using single and 2D arrays.
 */
public class MovieTicketReport {

    public static void main(String[] args) {
        // Single arrays: movie names (rows) and months (columns)
        String[] movies = {"Napoleon", "Oppenheimer"};
        String[] months = {"JAN", "FEB", "MAR"};

        // 2D array: ticket sales per movie per month
        int[][] ticketSales = {
            {3000, 1500, 1700},   // Napoleon
            {3500, 1200, 1600}    // Oppenheimer
        };

        MovieTickets movieTickets = new MovieTickets();
        int[] totals = new int[movies.length];

        System.out.println("MOVIE TICKET SALES REPORT - 2024");
        System.out.println();

        // Column headings
        System.out.printf("%-20s", "");
        for (String month : months) {
            System.out.printf("%-14s", month);
        }
        System.out.println();
        System.out.println("-".repeat(62));

        // One row per movie; work out each movie's total as we go
        for (int row = 0; row < ticketSales.length; row++) {
            System.out.printf("%-20s", movies[row]);
            for (int col = 0; col < ticketSales[row].length; col++) {
                System.out.printf("%-14d", ticketSales[row][col]);
            }
            System.out.println();
            totals[row] = movieTickets.TotalMovieSales(ticketSales[row]);
        }
        System.out.println();

        // Total per movie
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Total movie ticket sales for " + movies[i] + " " + totals[i]);
        }
        System.out.println();
        System.out.println("Top performing movie: " + movieTickets.TopMovie(movies, totals));
    }
}
