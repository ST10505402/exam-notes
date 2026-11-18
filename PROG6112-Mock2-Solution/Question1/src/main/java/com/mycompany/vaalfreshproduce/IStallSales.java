package com.mycompany.vaalfreshproduce;

/**
 * Q.1.2 - interface exactly as given in the paper.
 */
public interface IStallSales {
    int ProductTotal(int[] productSales);
    int TotalSales(int[][] stallSales);
    double AverageSales(int[][] stallSales);
    String TopProduct(String[] products, int[][] stallSales);
}
