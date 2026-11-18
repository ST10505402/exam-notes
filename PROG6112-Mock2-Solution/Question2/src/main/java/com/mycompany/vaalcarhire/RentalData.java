package com.mycompany.vaalcarhire;

/**
 * Q.2.8 - holds one rental's captured input. The number of days is an int,
 * so the form converts the text once (inside a try/catch) before creating this.
 */
public class RentalData {
    private final String customerName;
    private final String vehicleType;
    private final int numberOfDays;

    public RentalData(String customerName, String vehicleType, int numberOfDays) {
        this.customerName = customerName;
        this.vehicleType = vehicleType;
        this.numberOfDays = numberOfDays;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
}
