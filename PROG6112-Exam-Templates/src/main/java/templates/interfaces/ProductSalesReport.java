package templates.interfaces;

/**
 * TEMPLATE: complete exam Question 1 console app.
 * main() only declares the data, calls the class's methods and prints.
 */
public class ProductSalesReport {

    public static void main(String[] args) {
        String[] products = {"Microphone", "Speakers", "Mixing Desk"};
        String[] years = {"Year 1", "Year 2"};
        int[][] sales = {
            {300, 250},
            {150, 200},
            {700, 600}
        };
        final int SALES_LIMIT = 500;

        IProductSales calc = new ProductSales();   // interface type as the variable
        int[] totals = new int[products.length];

        System.out.println("PRODUCT SALES REPORT");
        System.out.println("------------------------------------------");
        System.out.printf("%-15s", "");
        for (String year : years) {
            System.out.printf("%-10s", year);
        }
        System.out.printf("%-10s%n", "Total");

        for (int r = 0; r < sales.length; r++) {
            System.out.printf("%-15s", products[r]);
            for (int c = 0; c < sales[r].length; c++) {
                System.out.printf("%-10d", sales[r][c]);
            }
            totals[r] = calc.RowTotal(sales[r]);
            System.out.printf("%-10d%n", totals[r]);
        }

        System.out.println("------------------------------------------");
        System.out.println("Total sales: " + calc.TotalSales(sales));
        System.out.printf("Average sales: %.0f%n", calc.AverageSales(sales));
        System.out.println("Maximum sale: " + calc.MaxSale(sales));
        System.out.println("Minimum sale: " + calc.MinSale(sales));
        System.out.println("Sales over " + SALES_LIMIT + ": " + calc.CountOverLimit(sales, SALES_LIMIT));
        System.out.println("Top product: " + calc.TopProduct(products, totals));
    }
}
