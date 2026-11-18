package templates.gui;

/**
 * TEMPLATE: interface for the GUI question's logic class.
 */
public interface IMovieTickets {
    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);
    boolean ValidateData(TicketData ticketData);
}
