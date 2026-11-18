package memos.exam2024.q1;

/**
 * 2024 Q1.2 - interface exactly as given in the paper.
 */
public interface IMovieTickets {
    int TotalMovieSales(int[] movieTicketSales);
    String TopMovie(String[] movies, int[] totalSales);
}
