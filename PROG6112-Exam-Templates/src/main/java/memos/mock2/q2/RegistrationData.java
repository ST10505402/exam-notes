package memos.mock2.q2;

/**
 * Mock 2 Q2.8 - one attendee's captured details (private fields, constructor, getters).
 */
public class RegistrationData {
    private final String firstName;
    private final String surname;
    private final String email;
    private final String ticketType;
    private final int days;
    private final boolean workshop;
    private final String reason;

    public RegistrationData(String firstName, String surname, String email, String ticketType,
                            int days, boolean workshop, String reason) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.ticketType = ticketType;
        this.days = days;
        this.workshop = workshop;
        this.reason = reason;
    }

    public String getFirstName() { return firstName; }
    public String getSurname() { return surname; }
    public String getEmail() { return email; }
    public String getTicketType() { return ticketType; }
    public int getDays() { return days; }
    public boolean hasWorkshop() { return workshop; }
    public String getReason() { return reason; }
}
