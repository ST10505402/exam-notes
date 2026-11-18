package com.mycompany.studentmarks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Q.1.3 - unit tests named exactly as the paper's table, plus extra checks.
 */
public class StudentMarksTest {

    private final StudentMarks studentMarks = new StudentMarks();
    private final int[][] marks = {
        {72, 65, 80},
        {45, 58, 49},
        {88, 91, 79}
    };

    @Test
    public void StudentAverage_ReturnsCorrectAverage() {
        int[] ayanda = {72, 65, 80};                                   // 217 / 3
        assertEquals(72.33, studentMarks.StudentAverage(ayanda), 0.01);
    }

    @Test
    public void CountBelowPassMark_ReturnsNumberOfMarksBelow() {
        assertEquals(2, studentMarks.CountBelowPassMark(marks, StudentMarks.PASS_MARK));   // 45 and 49
    }

    // ---- extra checks (not required by the paper) ----

    @Test
    public void HighestMark_ReturnsHighestMark() {
        assertEquals(91, studentMarks.HighestMark(marks));
    }

    @Test
    public void LowestMark_ReturnsLowestMark() {
        assertEquals(45, studentMarks.LowestMark(marks));
    }

    @Test
    public void CountBelowPassMark_FiftyIsAPass_NotCounted() {
        int[][] edge = {{50, 49}};
        assertEquals(1, studentMarks.CountBelowPassMark(edge, StudentMarks.PASS_MARK));
    }
}
