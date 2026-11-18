package com.mycompany.sedibengwater;

/**
 * Q.2.4 - interface exactly as given in the paper.
 */
public interface IWaterUsage {
    int[][] GetUsageData();
    int GetTotalUsage();
    double GetAverageUsage();
    int GetHighestReading();
    int GetReadingsOverLimit();
    int GetMonthsProcessed();
}
