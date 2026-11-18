package memos.exam2024.q2;

/**
 * 2024 Q2.7 - calculates the total ticket price (incl. 14% VAT) and validates the input.
 */
public class MovieTickets implements IMovieTickets {

    public static final double VAT_RATE = 0.14;

    // tickets x price + 14% VAT, rounded to 2 decimals.
    // Without rounding, 3 x 100 x 1.14 prints as 341.99999999999994 instead of 342.0
    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        double total = numberOfTickets * ticketPrice * (1 + VAT_RATE);
        return Math.round(total * 100) / 100.0;
    }

    // Name cannot be empty; price and number of tickets must be greater than 0
    @Override
    public boolean ValidateData(MovieTicketData data) {
        if (data == null) {
            return false;
        }
        String name = data.getMovieName();
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return data.getTicketPrice() > 0 && data.getNumberOfTickets() > 0;
    }
}
