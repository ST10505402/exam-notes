package memos.exam2024.q2;

/**
 * 2024 Q2.8 - interface exactly as given in the paper.
 */
public interface IMovieTickets {
    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);
    boolean ValidateData(MovieTicketData movieTicketData);
}
