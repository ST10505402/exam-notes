package memos.exam2024.q1;

/**
 * 2024 Q1.2 - calculates the total sales per movie and the top performing movie.
 */
public class MovieTickets implements IMovieTickets {

    // Adds up one movie's monthly ticket sales (one row of the 2D array)
    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        int total = 0;
        for (int sale : movieTicketSales) {
            total += sale;
        }
        return total;
    }

    // Returns the movie with the highest total (parallel arrays share the same index)
    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        int topIndex = 0;
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > totalSales[topIndex]) {
                topIndex = i;
            }
        }
        return movies[topIndex];
    }
}
