package templates.gui;

/**
 * TEMPLATE: data class passed to ValidateData (private fields, constructor, getters).
 */
public class TicketData {
    private final String movieName;
    private final int numberOfTickets;
    private final double ticketPrice;

    public TicketData(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieName() { return movieName; }
    public int getNumberOfTickets() { return numberOfTickets; }
    public double getTicketPrice() { return ticketPrice; }
}
