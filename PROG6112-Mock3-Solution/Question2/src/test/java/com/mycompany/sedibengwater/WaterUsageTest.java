package com.mycompany.sedibengwater;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Q.2.5 - unit tests named exactly as the paper's table, plus extra checks.
 */
public class WaterUsageTest {

    private final WaterUsage waterUsage = new WaterUsage();

    @Test
    public void GetReadingsOverLimit_ReturnsNumberOfReadings() {
        assertEquals(4, waterUsage.GetReadingsOverLimit());   // 27, 31, 26, 29
    }

    @Test
    public void GetHighestReading_ReturnsHighestReading() {
        assertEquals(31, waterUsage.GetHighestReading());
    }

    // ---- extra checks (not required by the paper) ----

    @Test
    public void GetTotalUsage_ReturnsTotal() {
        assertEquals(277, waterUsage.GetTotalUsage());
    }

    @Test
    public void GetAverageUsage_ReturnsUnroundedAverage() {
        assertEquals(23.08, waterUsage.GetAverageUsage(), 0.01);   // 277 / 12
    }

    @Test
    public void GetMonthsProcessed_ReturnsNumberOfRows() {
        assertEquals(4, waterUsage.GetMonthsProcessed());
    }
}
