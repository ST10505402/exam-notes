package memos.exam2024.q2;

/**
 * 2024 Q2.8 - holds the captured input passed to ValidateData.
 */
public class MovieTicketData {
    private final String movieName;
    private final int numberOfTickets;
    private final double ticketPrice;

    public MovieTicketData(String movieName, int numberOfTickets, double ticketPrice) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieName() { return movieName; }
    public int getNumberOfTickets() { return numberOfTickets; }
    public double getTicketPrice() { return ticketPrice; }
}
