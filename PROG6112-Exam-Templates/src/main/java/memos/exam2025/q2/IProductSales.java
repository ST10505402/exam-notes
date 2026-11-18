package memos.exam2025.q2;

/**
 * 2025 Q2.4 - interface exactly as given in the paper.
 */
public interface IProductSales {
    int[][] GetProductSales();
    int GetTotalSales();
    int GetSalesOverLimit();
    int GetSalesUnderLimit();
    int GetProductsProcessed();
    double GetAverageSales();
}
