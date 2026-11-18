package memos.mock2.q2;

/**
 * Mock 2 Q2.8 - interface exactly as given in the question.
 */
public interface IRegistration {
    double GetTicketPrice(String ticketType);
    double CalculateSubtotal(String ticketType, int days, boolean workshop);
    double CalculateDiscount(String ticketType, double subtotal);
    boolean ValidateEmail(String email);
    int CountWords(String text);
    boolean ValidateData(RegistrationData registrationData);
}
