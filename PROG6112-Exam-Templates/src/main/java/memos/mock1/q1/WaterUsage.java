package memos.mock1.q1;

/**
 * Performs all water usage calculations for the complex.
 */
public class WaterUsage implements IWaterUsage {

    // Adds up every monthly reading for one unit (one row of the 2D array)
    @Override
    public int TotalUsage(int[] unitUsage) {
        int total = 0;
        for (int reading : unitUsage) {
            total += reading;
        }
        return total;
    }

    // Average monthly reading for one unit; cast to double to avoid integer division
    @Override
    public double AverageUsage(int[] unitUsage) {
        if (unitUsage.length == 0) {
            return 0;
        }
        return (double) TotalUsage(unitUsage) / unitUsage.length;
    }

    // Highest single monthly reading anywhere in the 2D array
    @Override
    public int HighestReading(int[][] waterUsage) {
        int highest = waterUsage[0][0];
        for (int row = 0; row < waterUsage.length; row++) {
            for (int col = 0; col < waterUsage[row].length; col++) {
                if (waterUsage[row][col] > highest) {
                    highest = waterUsage[row][col];
                }
            }
        }
        return highest;
    }

    // Name of the unit with the smallest total (parallel arrays: same index)
    @Override
    public String LowestUser(String[] units, int[] totals) {
        int lowestIndex = 0;
        for (int i = 1; i < totals.length; i++) {
            if (totals[i] < totals[lowestIndex]) {
                lowestIndex = i;
            }
        }
        return units[lowestIndex];
    }
}
