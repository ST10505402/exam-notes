package com.mycompany.vaalfreshproduce;

/**
 * Q.1.2 - all calculations for the farm stall sales report.
 */
public class StallSales implements IStallSales {

    // Total for one product = one row of the 2D array
    @Override
    public int ProductTotal(int[] productSales) {
        int total = 0;
        for (int sale : productSales) {
            total += sale;
        }
        return total;
    }

    // Overall total: add up every row using ProductTotal (no repeated loop logic)
    @Override
    public int TotalSales(int[][] stallSales) {
        int total = 0;
        for (int[] productSales : stallSales) {
            total += ProductTotal(productSales);
        }
        return total;
    }

    // Average per quarter; cast to double BEFORE dividing so 1465 / 12 = 122.08, not 122
    @Override
    public double AverageSales(int[][] stallSales) {
        int count = 0;
        for (int[] productSales : stallSales) {
            count += productSales.length;
        }
        return count == 0 ? 0 : (double) TotalSales(stallSales) / count;
    }

    // Product with the highest TOTAL (not the highest single quarter)
    @Override
    public String TopProduct(String[] products, int[][] stallSales) {
        int topIndex = 0;
        int topTotal = ProductTotal(stallSales[0]);
        for (int row = 1; row < stallSales.length; row++) {
            int rowTotal = ProductTotal(stallSales[row]);
            if (rowTotal > topTotal) {
                topTotal = rowTotal;
                topIndex = row;
            }
        }
        return products[topIndex];   // parallel arrays: same index = same product
    }
}
