package com.mycompany.vaalcarhire;

/**
 * Q.2.8 - interface exactly as given in the paper.
 */
public interface ICarHire {
    double GetDailyRate(String vehicleType);
    double CalculateRentalCost(String vehicleType, int numberOfDays);
    boolean ValidateData(RentalData rentalData);
}
