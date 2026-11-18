package templates.arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * TEMPLATE: sorting arrays.
 * Bubble sort (ascending + descending), insertion sort, sorting parallel arrays
 * together, and the built-in Arrays.sort.
 */
public class SortingTemplate {

    // Bubble sort, ascending, with both efficiency improvements:
    // 1) each pass stops earlier (the end is already sorted)
    // 2) stop completely when a pass makes no swaps
    public static void bubbleSortAscending(int[] values) {
        boolean swapped = true;
        for (int pass = 0; pass < values.length - 1 && swapped; pass++) {
            swapped = false;
            for (int i = 0; i < values.length - 1 - pass; i++) {
                if (values[i] > values[i + 1]) {          // change > to < for descending
                    int temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    // Bubble sort, descending
    public static void bubbleSortDescending(int[] values) {
        for (int pass = 0; pass < values.length - 1; pass++) {
            for (int i = 0; i < values.length - 1 - pass; i++) {
                if (values[i] < values[i + 1]) {
                    int temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                }
            }
        }
    }

    // Bubble sort for Strings (alphabetical) - use compareTo, never < or >
    public static void bubbleSortStrings(String[] names) {
        for (int pass = 0; pass < names.length - 1; pass++) {
            for (int i = 0; i < names.length - 1 - pass; i++) {
                if (names[i].compareTo(names[i + 1]) > 0) {
                    String temp = names[i];
                    names[i] = names[i + 1];
                    names[i + 1] = temp;
                }
            }
        }
    }

    // Sort PARALLEL arrays: sort by sales (highest first) and swap names at the same time
    // so each name stays with its own sales figure.
    public static void sortParallelBySalesDescending(String[] names, int[] sales) {
        for (int pass = 0; pass < sales.length - 1; pass++) {
            for (int i = 0; i < sales.length - 1 - pass; i++) {
                if (sales[i] < sales[i + 1]) {
                    int tempSale = sales[i];
                    sales[i] = sales[i + 1];
                    sales[i + 1] = tempSale;

                    String tempName = names[i];        // swap the matching name too
                    names[i] = names[i + 1];
                    names[i + 1] = tempName;
                }
            }
        }
    }

    // Insertion sort: shift bigger values right, drop the key into the gap
    public static void insertionSort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            int key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] a = {700, 150, 300, 600, 250, 200};
        bubbleSortAscending(a);
        System.out.println("Bubble ascending:  " + Arrays.toString(a));

        int[] b = {700, 150, 300, 600, 250, 200};
        bubbleSortDescending(b);
        System.out.println("Bubble descending: " + Arrays.toString(b));

        int[] c = {700, 150, 300, 600, 250, 200};
        insertionSort(c);
        System.out.println("Insertion sort:    " + Arrays.toString(c));

        String[] names = {"Oppenheimer", "Damsel", "Napoleon"};
        bubbleSortStrings(names);
        System.out.println("Strings A-Z:       " + Arrays.toString(names));

        String[] movies = {"Napoleon", "Oppenheimer", "Damsel"};
        int[] totals = {6200, 6300, 4100};
        sortParallelBySalesDescending(movies, totals);
        System.out.println("Ranked: " + Arrays.toString(movies) + " " + Arrays.toString(totals));

        // Built-in alternatives
        int[] d = {5, 2, 9};
        Arrays.sort(d);                                          // ascending
        Integer[] e = {5, 2, 9};
        Arrays.sort(e, Collections.reverseOrder());              // descending (object array)
        System.out.println("Arrays.sort: " + Arrays.toString(d) + " reverse: " + Arrays.toString(e));
    }
}
