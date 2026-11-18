package memos.mock2.q2;

/**
 * Mock 2 Q2.8 - all pricing and validation for the Vaal Tech Expo registration.
 */
public class Registration implements IRegistration {

    public static final double WORKSHOP_PRICE = 100.0;
    public static final double STUDENT_DISCOUNT_RATE = 0.20;
    public static final int MIN_WORDS = 5;
    public static final int MAX_WORDS = 50;

    // Price per day; 0 for "-- Select --" or anything unknown
    @Override
    public double GetTicketPrice(String ticketType) {
        if (ticketType == null) {
            return 0;
        }
        switch (ticketType) {
            case "Student":  return 50.0;
            case "Standard": return 150.0;
            case "VIP":      return 400.0;
            default:         return 0;
        }
    }

    // (price per day x days) + workshop once
    @Override
    public double CalculateSubtotal(String ticketType, int days, boolean workshop) {
        double subtotal = GetTicketPrice(ticketType) * days;
        if (workshop) {
            subtotal += WORKSHOP_PRICE;
        }
        return subtotal;
    }

    // 20% off for Student tickets only
    @Override
    public double CalculateDiscount(String ticketType, double subtotal) {
        if ("Student".equals(ticketType)) {
            return subtotal * STUDENT_DISCOUNT_RATE;
        }
        return 0;
    }

    // Exactly one @, at least one character before it, and a full stop after it
    @Override
    public boolean ValidateEmail(String email) {
        if (email == null) {
            return false;
        }
        String trimmed = email.trim();
        int at = trimmed.indexOf('@');
        if (at < 1 || at != trimmed.lastIndexOf('@')) {
            return false;                              // no @, nothing before it, or more than one
        }
        return trimmed.indexOf('.', at + 1) > at;      // a full stop somewhere after the @
    }

    // Words separated by any amount of whitespace
    @Override
    public int CountWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }

    // Every rule in Q.2.5
    @Override
    public boolean ValidateData(RegistrationData data) {
        if (data == null) {
            return false;
        }
        if (isBlank(data.getFirstName()) || isBlank(data.getSurname())) {
            return false;
        }
        if (!ValidateEmail(data.getEmail())) {
            return false;
        }
        if (GetTicketPrice(data.getTicketType()) == 0) {
            return false;
        }
        if (data.getDays() != 1 && data.getDays() != 2) {
            return false;
        }
        int words = CountWords(data.getReason());
        return words >= MIN_WORDS && words <= MAX_WORDS;
    }

    private boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }
}
