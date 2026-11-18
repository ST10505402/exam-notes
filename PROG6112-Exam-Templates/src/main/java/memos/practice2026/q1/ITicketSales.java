package memos.practice2026.q1;

/**
 * Practice 2026 Q1.2 - interface exactly as given in the paper.
 */
public interface ITicketSales {
    int TotalTicketSales(int[][] ticketSales);
    double AverageTicketSales(int[][] ticketSales);
    int HighestSale(int[][] ticketSales);
    int LowestSale(int[][] ticketSales);
}
