package templates.interfaces;

/**
 * TEMPLATE: class that implements an interface.
 * Tip: in NetBeans type "implements IProductSales", click the lightbulb,
 * then "Implement all abstract methods" to generate the headers.
 */
public class ProductSales implements IProductSales {
    
    public 

    // Sum of every value in the 2D array
    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int[] row : productSales) {
            for (int value : row) {
                total += value;
            }
        }
        return total;
    }

    // Average of every value; cast to double to avoid integer division
    @Override
    public double AverageSales(int[][] productSales) {
        int count = 0;
        for (int[] row : productSales) {
            count += row.length;
        }
        if (count == 0) {
            return 0;
        }
        return (double) TotalSales(productSales) / count;   // reuse, don't repeat
    }

    // Largest single value; start from a real element
    @Override
    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0];
        for (int[] row : productSales) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    // Smallest single value
    @Override
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0];
        for (int[] row : productSales) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    // Total of one row (pass sales[r])
    @Override
    public int RowTotal(int[] rowSales) {
        int total = 0;
        for (int value : rowSales) {
            total += value;
        }
        return total;
    }

    // Name of the item with the largest total (parallel arrays)
    @Override
    public String TopProduct(String[] products, int[] totals) {
        int top = 0;
        for (int i = 1; i < totals.length; i++) {
            if (totals[i] > totals[top]) {
                top = i;
            }
        }
        return products[top];
    }

    // How many single values are above the limit
    @Override
    public int CountOverLimit(int[][] productSales, int limit) {
        int count = 0;
        for (int[] row : productSales) {
            for (int value : row) {
                if (value > limit) {
                    count++;
                }
            }
        }
        return count;
    }
}
