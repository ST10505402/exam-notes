package memos.exam2025.q1;

/**
 * 2025 Q1.2 - total, average, maximum and minimum of the 2D product sales array.
 */
public class ProductSales implements IProduct {

    // Sum of every value in the 2D array
    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int row = 0; row < productSales.length; row++) {
            for (int col = 0; col < productSales[row].length; col++) {
                total += productSales[row][col];
            }
        }
        return total;
    }

    // Average per sale; cast to double so 2200 / 6 = 366.67, not 366
    @Override
    public double AverageSales(int[][] productSales) {
        int count = 0;
        for (int[] row : productSales) {
            count += row.length;
        }
        return count == 0 ? 0 : (double) TotalSales(productSales) / count;
    }

    // Largest single sale; start from a real element
    @Override
    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0];
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale > max) {
                    max = sale;
                }
            }
        }
        return max;
    }

    // Smallest single sale
    @Override
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0];
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale < min) {
                    min = sale;
                }
            }
        }
        return min;
    }
}
