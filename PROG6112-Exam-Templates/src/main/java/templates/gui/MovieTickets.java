package templates.gui;

/**
 * TEMPLATE: logic class for the GUI question - calculation + validation, no GUI code.
 */
public class MovieTickets implements IMovieTickets {

    public static final double VAT_RATE = 0.15;   // check the rate your paper gives

    // Number of tickets x price, plus VAT
    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double subtotal = numberOfTickets * ticketPrice;
        return subtotal + subtotal * VAT_RATE;
    }

    // Name not empty; tickets and price greater than 0
    @Override
    public boolean ValidateData(TicketData data) {
        if (data == null) {
            return false;
        }
        String name = data.getMovieName();
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return data.getNumberOfTickets() > 0 && data.getTicketPrice() > 0;
    }
}
