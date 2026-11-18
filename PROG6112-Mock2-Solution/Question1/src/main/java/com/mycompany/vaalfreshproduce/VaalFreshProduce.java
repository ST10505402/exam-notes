package com.mycompany.vaalfreshproduce;

/**
 * Q.1.1 - prints the farm stall sales report using single and 2D arrays.
 */
public class VaalFreshProduce {

    public static void main(String[] args) {
        // Single arrays: product names (rows) and quarter headings (columns)
        String[] products = {"Tomatoes", "Spinach", "Potatoes"};
        String[] quarters = {"Q1", "Q2", "Q3", "Q4"};

        // 2D array: kilograms sold per product per quarter
        int[][] stallSalesData = {
            {120, 95, 80, 140},    // Tomatoes
            {60, 75, 90, 55},      // Spinach
            {200, 180, 160, 210}   // Potatoes
        };

        StallSales stallSales = new StallSales();

        // Each row of the 2D array is an int[], so pass it straight to ProductTotal
        int[] productTotals = new int[products.length];
        for (int row = 0; row < stallSalesData.length; row++) {
            productTotals[row] = stallSales.ProductTotal(stallSalesData[row]);
        }

        printReport(products, quarters, stallSalesData, productTotals,
                stallSales.TotalSales(stallSalesData),
                stallSales.AverageSales(stallSalesData),
                stallSales.TopProduct(products, stallSalesData));
    }

    // Prints the table (rows and columns) followed by the summary
    private static void printReport(String[] products, String[] quarters, int[][] data,
                                    int[] productTotals, int total, double average, String topProduct) {
        String line = "-".repeat(50);

        System.out.println("FARM STALL SALES REPORT - 2026 (kg)");
        System.out.println(line);

        // Column headings
        System.out.printf("%-12s", "");
        for (String quarter : quarters) {
            System.out.printf("%-7s", quarter);
        }
        System.out.println("TOTAL");

        // One row per product, then its total
        for (int row = 0; row < data.length; row++) {
            System.out.printf("%-12s", products[row]);
            for (int col = 0; col < data[row].length; col++) {
                System.out.printf("%-7d", data[row][col]);
            }
            System.out.println(productTotals[row]);
        }
        System.out.println(line);

        // Summary - the average is rounded only when it is printed
        System.out.println("Total sold:            " + total);
        System.out.println("Average per quarter:   " + Math.round(average));
        System.out.println("Top product:           " + topProduct);
        System.out.println(line);
    }
}
