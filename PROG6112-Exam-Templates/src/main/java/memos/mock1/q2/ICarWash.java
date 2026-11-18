package memos.mock1.q2;

/**
 * Interface supplied in the exam paper.
 */
public interface ICarWash {
    double GetWashPrice(String washType);
    double CalculateSubtotal(String washType, int numberOfVehicles, boolean tyreShine);
    double CalculateDiscount(double subtotal, int numberOfVehicles);
    boolean ValidateData(BookingData bookingData);
}
