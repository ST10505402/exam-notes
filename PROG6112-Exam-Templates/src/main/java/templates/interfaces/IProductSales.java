package templates.interfaces;

/**
 * TEMPLATE: interface. In the exam, COPY the interface exactly as given
 * (including capitalised method names) and implement every method.
 */
public interface IProductSales {
    int TotalSales(int[][] productSales);
    double AverageSales(int[][] productSales);
    int MaxSale(int[][] productSales);
    int MinSale(int[][] productSales);
    int RowTotal(int[] rowSales);
    String TopProduct(String[] products, int[] totals);
    int CountOverLimit(int[][] productSales, int limit);
}
