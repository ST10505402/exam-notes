package memos.mock1.q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the WaterUsage class.
 */
public class WaterUsageTest {

    private final WaterUsage calculator = new WaterUsage();

    @Test
    public void TotalUsage_ReturnsTotalForUnit() {
        int[] unit2 = {18, 20, 17, 19};
        assertEquals(74, calculator.TotalUsage(unit2));
    }

    @Test
    public void LowestUser_ReturnsUnitWithLowestTotal() {
        String[] units = {"Unit 1", "Unit 2", "Unit 3"};
        int[] totals = {52, 74, 40};
        assertEquals("Unit 3", calculator.LowestUser(units, totals));
    }
}
