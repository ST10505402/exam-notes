package memos.mock1.q2;

/**
 * Business logic for Kasi Shine Car Wash: prices, discount and validation.
 */
public class CarWash implements ICarWash {

    // Constants avoid "magic numbers" scattered through the code
    public static final double TYRE_SHINE_PRICE = 25.0;
    public static final double DISCOUNT_RATE = 0.10;
    public static final int DISCOUNT_MIN_VEHICLES = 3;
    public static final int MAX_VEHICLES = 10;

    // Price per vehicle for each wash type; 0 for an unknown type
    @Override
    public double GetWashPrice(String washType) {
        if (washType == null) {
            return 0;
        }
        switch (washType) {
            case "Basic": return 80.0;
            case "Full":  return 150.0;
            case "Valet": return 300.0;
            default:      return 0;
        }
    }

    // (wash price + optional tyre shine) x number of vehicles
    @Override
    public double CalculateSubtotal(String washType, int numberOfVehicles, boolean tyreShine) {
        double pricePerVehicle = GetWashPrice(washType);
        if (tyreShine) {
            pricePerVehicle += TYRE_SHINE_PRICE;
        }
        return pricePerVehicle * numberOfVehicles;
    }

    // 10% off the subtotal when 3 or more vehicles are booked
    @Override
    public double CalculateDiscount(double subtotal, int numberOfVehicles) {
        if (numberOfVehicles >= DISCOUNT_MIN_VEHICLES) {
            return subtotal * DISCOUNT_RATE;
        }
        return 0;
    }

    // Name not empty, wash type known, vehicles between 1 and 10
    @Override
    public boolean ValidateData(BookingData bookingData) {
        if (bookingData == null) {
            return false;
        }
        String name = bookingData.getCustomerName();
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (GetWashPrice(bookingData.getWashType()) == 0) {
            return false;
        }
        int vehicles = bookingData.getNumberOfVehicles();
        return vehicles >= 1 && vehicles <= MAX_VEHICLES;
    }
}
