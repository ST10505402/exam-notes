package templates.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
// JUnit 4 project instead: import org.junit.Test; import static org.junit.Assert.*;

/**
 * TEMPLATE: testing methods that change an array (void methods) - check the array afterwards.
 */
public class SortingTemplateTest {

    @Test
    public void BubbleSortAscending_SortsLowToHigh() {
        int[] values = {700, 150, 300};
        SortingTemplate.bubbleSortAscending(values);
        assertArrayEquals(new int[] {150, 300, 700}, values);
    }

    @Test
    public void BubbleSortDescending_SortsHighToLow() {
        int[] values = {150, 700, 300};
        SortingTemplate.bubbleSortDescending(values);
        assertArrayEquals(new int[] {700, 300, 150}, values);
    }

    @Test
    public void InsertionSort_SortsLowToHigh() {
        int[] values = {5, 1, 4, 2};
        SortingTemplate.insertionSort(values);
        assertArrayEquals(new int[] {1, 2, 4, 5}, values);
    }

    @Test
    public void SortParallel_KeepsNamesWithTheirSales() {
        String[] names = {"Napoleon", "Oppenheimer", "Damsel"};
        int[] sales = {6200, 6300, 4100};
        SortingTemplate.sortParallelBySalesDescending(names, sales);
        assertEquals("Oppenheimer", names[0]);
        assertEquals(6300, sales[0]);
        assertEquals("Damsel", names[2]);
    }

    @Test
    public void Total_TwoDArray_ReturnsGrandTotal() {
        int[][] sales = {{300, 250}, {150, 200}, {700, 600}};
        assertEquals(2200, TwoDArrayTemplate.total(sales));
    }

    @Test
    public void Total_SingleRow_ReturnsRowTotal() {
        assertEquals(550, TwoDArrayTemplate.total(new int[] {300, 250}));
    }
}
