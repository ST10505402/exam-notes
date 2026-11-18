package com.mycompany.sedibengwater;

/**
 * Q.2.4 - holds the usage data ("from memory") and performs every calculation.
 */
public class WaterUsage implements IWaterUsage {

    public static final int USAGE_LIMIT = 25;    // kl; over the limit = greater than 25

    // Rows = months (Jan-Apr), columns = households A, B, C
    private final int[][] usageData = {
        {18, 27, 22},   // January
        {20, 31, 19},   // February
        {24, 26, 17},   // March
        {21, 29, 23}    // April
    };

    @Override
    public int[][] GetUsageData() {
        return usageData;
    }

    // Sum of every reading
    @Override
    public int GetTotalUsage() {
        int total = 0;
        for (int[] month : usageData) {
            for (int reading : month) {
                total += reading;
            }
        }
        return total;
    }

    // Average per reading; cast to double before dividing (rounded only when displayed)
    @Override
    public double GetAverageUsage() {
        int count = 0;
        for (int[] month : usageData) {
            count += month.length;
        }
        return count == 0 ? 0 : (double) GetTotalUsage() / count;
    }

    // Highest single reading; start from a real element
    @Override
    public int GetHighestReading() {
        int highest = usageData[0][0];
        for (int[] month : usageData) {
            for (int reading : month) {
                if (reading > highest) {
                    highest = reading;
                }
            }
        }
        return highest;
    }

    // Readings strictly greater than the limit
    @Override
    public int GetReadingsOverLimit() {
        int count = 0;
        for (int[] month : usageData) {
            for (int reading : month) {
                if (reading > USAGE_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    // Months processed = number of rows, worked out from the array
    @Override
    public int GetMonthsProcessed() {
        return usageData.length;
    }
}
