package com.mycompany.vaalcarhire;

/**
 * Q.2.7 - daily rates, rental cost (with the 7-day discount) and validation.
 */
public class CarHire implements ICarHire {

    public static final double DISCOUNT_RATE = 0.10;   // 10% off
    public static final int DISCOUNT_DAYS = 7;         // from 7 days
    public static final int MAX_DAYS = 30;

    // Rate per day for each vehicle; 0 for anything else
    @Override
    public double GetDailyRate(String vehicleType) {
        if (vehicleType == null) {
            return 0;
        }
        switch (vehicleType) {
            case "Hatchback": return 350.00;
            case "Sedan":     return 500.00;
            case "SUV":       return 800.00;
            default:          return 0;
        }
    }

    // Daily rate x days, then 10% off the cost for 7 days or more
    @Override
    public double CalculateRentalCost(String vehicleType, int numberOfDays) {
        double cost = GetDailyRate(vehicleType) * numberOfDays;
        if (numberOfDays >= DISCOUNT_DAYS) {
            cost -= cost * DISCOUNT_RATE;     // multiply by the rate - never divide
        }
        return cost;
    }

    // Name required; known vehicle; days from 1 to 30 (&& = both must be true)
    @Override
    public boolean ValidateData(RentalData rentalData) {
        if (rentalData == null) {
            return false;
        }
        String name = rentalData.getCustomerName();
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (GetDailyRate(rentalData.getVehicleType()) == 0) {
            return false;
        }
        int days = rentalData.getNumberOfDays();
        return days >= 1 && days <= MAX_DAYS;
    }

    // True when the 7-day discount applies (keeps the rule in one place)
    public boolean IsDiscountApplied(int numberOfDays) {
        return numberOfDays >= DISCOUNT_DAYS;
    }
}
