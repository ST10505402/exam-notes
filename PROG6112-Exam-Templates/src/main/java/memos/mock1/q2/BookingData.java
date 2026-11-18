package memos.mock1.q2;

/**
 * Holds the details captured for one booking (information hiding: private fields + getters).
 */
public class BookingData {
    private final String customerName;
    private final String washType;
    private final int numberOfVehicles;

    public BookingData(String customerName, String washType, int numberOfVehicles) {
        this.customerName = customerName;
        this.washType = washType;
        this.numberOfVehicles = numberOfVehicles;
    }

    public String getCustomerName() { return customerName; }
    public String getWashType() { return washType; }
    public int getNumberOfVehicles() { return numberOfVehicles; }
}
