package memos.exam2025.q2;

/**
 * 2025 Q2.4 - holds the sales data and performs every calculation.
 */
public class ProductSales implements IProductSales {

    public static final int SALES_LIMIT = 500;

    // Rows = years, columns = Microphone, Speakers, Mixing Desk
    private final int[][] productSales = {
        {300, 150, 700},   // year 1
        {250, 200, 600}    // year 2
    };

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    // Sum of every sale
    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    // Sales greater than the limit
    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    // Sales at or below the limit
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale <= SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    // Years processed = number of rows, worked out from the array
    @Override
    public int GetProductsProcessed() {
        return productSales.length;
    }

    // Average per sale
    @Override
    public double GetAverageSales() {
        int count = 0;
        for (int[] year : productSales) {
            count += year.length;
        }
        return count == 0 ? 0 : (double) GetTotalSales() / count;
    }
}
