package memos.mock1.q1;

/**
 * Interface supplied in the exam paper.
 */
public interface IWaterUsage {
    int TotalUsage(int[] unitUsage);
    double AverageUsage(int[] unitUsage);
    int HighestReading(int[][] waterUsage);
    String LowestUser(String[] units, int[] totals);
}
