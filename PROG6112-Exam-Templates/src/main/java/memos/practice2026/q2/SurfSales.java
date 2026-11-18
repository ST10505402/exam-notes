package memos.practice2026.q2;

/**
 * Practice 2026 Q2.4 - Southcoast Surf Co. sales calculations.
 */
public class SurfSales implements ISurfSales {

    public static final int SALES_TARGET = 400;    // stored as a constant, as required

    // Rows = years, columns = Surfboards, Wetsuits, Bodyboards
    private final int[][] productSales = {
        {520, 380, 150},   // year 1
        {610, 340, 210},   // year 2
        {450, 290, 200}    // year 3
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

    // Over target = greater than 400
    @Override
    public int GetSalesOverTarget() {
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > SALES_TARGET) {
                    count++;
                }
            }
        }
        return count;
    }

    // Under target = 400 or less
    @Override
    public int GetSalesUnderTarget() {
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale <= SALES_TARGET) {
                    count++;
                }
            }
        }
        return count;
    }

    // Worked out from the array, not typed in
    @Override
    public int GetYearsProcessed() {
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
