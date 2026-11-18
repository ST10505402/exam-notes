package memos.practice2026.q2;

/**
 * Practice 2026 Q2.4 - interface exactly as given in the paper.
 */
public interface ISurfSales {
    int[][] GetProductSales();
    int GetTotalSales();
    int GetSalesOverTarget();
    int GetSalesUnderTarget();
    int GetYearsProcessed();
    double GetAverageSales();
}
