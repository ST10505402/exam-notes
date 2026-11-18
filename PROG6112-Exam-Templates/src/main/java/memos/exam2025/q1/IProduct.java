package memos.exam2025.q1;

/**
 * 2025 Q1.2 - interface exactly as given in the paper (the code names it IProduct).
 */
public interface IProduct {
    int TotalSales(int[][] productSales);
    double AverageSales(int[][] productSales);
    int MaxSale(int[][] productSales);
    int MinSale(int[][] productSales);
}
