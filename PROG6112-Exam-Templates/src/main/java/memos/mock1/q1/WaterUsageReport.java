package memos.mock1.q1;

/**
 * Question 1: produces the water usage report for Willow Court complex.
 */
public class WaterUsageReport {

    public static void main(String[] args) {
        // Single arrays: unit names (rows) and month headings (columns)
        String[] units = {"Unit 1", "Unit 2", "Unit 3"};
        String[] months = {"JAN", "FEB", "MAR", "APR"};

        // Two-dimensional array: monthly readings in kilolitres per unit
        int[][] waterUsage = {
            {12, 15, 11, 14},   // Unit 1
            {18, 20, 17, 19},   // Unit 2
            {9, 10, 8, 13}      // Unit 3
        };

        WaterUsage calculator = new WaterUsage();
        int[] totals = new int[units.length];

        System.out.println("WATER USAGE REPORT (kilolitres)");
        System.out.println("-------------------------------------------------------");

        // Header row
        System.out.printf("%-10s", "");
        for (String month : months) {
            System.out.printf("%-7s", month);
        }
        System.out.printf("%-7s%-7s%n", "TOTAL", "AVG");

        // One row per unit: readings, then total and average
        for (int row = 0; row < waterUsage.length; row++) {
            System.out.printf("%-10s", units[row]);
            for (int col = 0; col < waterUsage[row].length; col++) {
                System.out.printf("%-7d", waterUsage[row][col]);
            }
            totals[row] = calculator.TotalUsage(waterUsage[row]);
            double average = calculator.AverageUsage(waterUsage[row]);
            System.out.printf("%-7d%-7.1f%n", totals[row], average);
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Highest single monthly reading: " + calculator.HighestReading(waterUsage) + " kl");
        System.out.println("Unit with the lowest total usage: " + calculator.LowestUser(units, totals));
    }
}
