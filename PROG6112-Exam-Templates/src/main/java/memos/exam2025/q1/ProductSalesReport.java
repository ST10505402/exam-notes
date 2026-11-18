package memos.exam2025.q1;

/**
 * 2025 Q1.1 - product sales report: rows and columns, then total, average, max and min.
 */
public class ProductSalesReport {

    public static void main(String[] args) {
        // Single arrays: row and column headings
        String[] years = {"YEAR 1", "YEAR 2"};
        String[] quarters = {"QUARTER 1", "QUARTER 2", "QUARTER 3"};

        // 2D array: [year][quarter]
        int[][] productSales = {
            {300, 150, 700},
            {250, 200, 600}
        };

        ProductSales sales = new ProductSales();
        String line = "-".repeat(46);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println(line);

        // Rows and columns (rubric: "printing of rows and columns in the report")
        System.out.printf("%-10s", "");
        for (String quarter : quarters) {
            System.out.printf("%-12s", quarter);
        }
        System.out.println();
        for (int row = 0; row < productSales.length; row++) {
            System.out.printf("%-10s", years[row]);
            for (int col = 0; col < productSales[row].length; col++) {
                System.out.printf("%-12d", productSales[row][col]);
            }
            System.out.println();
        }
        System.out.println(line);

        // Summary as per the sample screenshot (average rounded to a whole number)
        System.out.println("Total sales:    " + sales.TotalSales(productSales));
        System.out.println("Average sales:  " + Math.round(sales.AverageSales(productSales)));
        System.out.println("Maximum sale:   " + sales.MaxSale(productSales));
        System.out.println("Minimum sale:   " + sales.MinSale(productSales));
        System.out.println(line);
    }
}
