package templates.arrays;

/**
 * TEMPLATE: single + two-dimensional arrays (exam Question 1).
 * Declare, populate, print as a table, row totals, column totals, grand total,
 * averages, highest/lowest value (with position), top performer, search, counts over a limit.
 */
public class TwoDArrayTemplate {

    public static void main(String[] args) {
        // ---------- 1. DECLARE AND POPULATE ----------
        // Single (parallel) arrays: row names and column headings
        String[] items = {"Microphone", "Speakers", "Mixing Desk"};
        String[] periods = {"YEAR 1", "YEAR 2"};

        // 2D array: [row][column] -> here rows = items, columns = years
        int[][] sales = {
            {300, 250},   // Microphone
            {150, 200},   // Speakers
            {700, 600}    // Mixing Desk
        };

        // Alternative: declare empty, then fill with nested loops (e.g. from user input)
        int[][] empty = new int[3][2];
        for (int row = 0; row < empty.length; row++) {
            for (int col = 0; col < empty[row].length; col++) {
                empty[row][col] = (row + 1) * 10;    // replace with your value / input
            }
        }

        // ---------- 2. PRINT AS A TABLE (rows + columns) ----------
        System.out.println("PRODUCT SALES REPORT");
        System.out.println("----------------------------------------");
        System.out.printf("%-15s", "");                 // empty top-left corner
        for (String period : periods) {
            System.out.printf("%-10s", period);         // column headings
        }
        System.out.printf("%-10s%n", "TOTAL");

        int[] rowTotals = new int[sales.length];
        for (int row = 0; row < sales.length; row++) {
            System.out.printf("%-15s", items[row]);      // row name from the parallel array
            for (int col = 0; col < sales[row].length; col++) {
                System.out.printf("%-10d", sales[row][col]);
                rowTotals[row] += sales[row][col];       // accumulate the row total as we go
            }
            System.out.printf("%-10d%n", rowTotals[row]);
        }
        System.out.println("----------------------------------------");

        // ---------- 3. COLUMN TOTALS (swap the loops: outer = column) ----------
        System.out.printf("%-15s", "TOTAL");
        int grandTotal = 0;
        for (int col = 0; col < sales[0].length; col++) {
            int columnTotal = 0;
            for (int row = 0; row < sales.length; row++) {
                columnTotal += sales[row][col];
            }
            grandTotal += columnTotal;
            System.out.printf("%-10d", columnTotal);
        }
        System.out.printf("%-10d%n%n", grandTotal);

        // ---------- 4. AVERAGE (cast to double - avoid integer division) ----------
        int count = sales.length * sales[0].length;
        double average = (double) grandTotal / count;
        System.out.printf("Average sale: %.2f%n", average);

        // ---------- 5. HIGHEST AND LOWEST (start from a real element, not 0) ----------
        int highest = sales[0][0];
        int lowest = sales[0][0];
        int highRow = 0, highCol = 0;
        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                if (sales[row][col] > highest) {
                    highest = sales[row][col];
                    highRow = row;
                    highCol = col;
                }
                if (sales[row][col] < lowest) {
                    lowest = sales[row][col];
                }
            }
        }
        System.out.println("Highest sale: " + highest + " (" + items[highRow] + ", " + periods[highCol] + ")");
        System.out.println("Lowest sale: " + lowest);

        // ---------- 6. TOP PERFORMER (index of the largest row total) ----------
        int topIndex = 0;
        for (int i = 1; i < rowTotals.length; i++) {
            if (rowTotals[i] > rowTotals[topIndex]) {
                topIndex = i;
            }
        }
        System.out.println("Top performing product: " + items[topIndex]);

        // ---------- 7. COUNT OVER / UNDER A LIMIT ----------
        final int SALES_LIMIT = 500;
        int over = 0, under = 0;
        for (int[] rowValues : sales) {            // for-each over rows, then values
            for (int value : rowValues) {
                if (value > SALES_LIMIT) {
                    over++;
                } else {
                    under++;
                }
            }
        }
        System.out.println("Sales over limit: " + over + ", under limit: " + under);

        // ---------- 8. SEARCH for a name, then print that row ----------
        String searchFor = "Speakers";
        int foundIndex = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(searchFor)) {   // equals for Strings, never ==
                foundIndex = i;
                break;
            }
        }
        if (foundIndex >= 0) {
            System.out.println(searchFor + " total: " + rowTotals[foundIndex]);
        } else {
            System.out.println(searchFor + " not found");
        }

        // ---------- 9. PASS A 2D ARRAY / ONE ROW TO A METHOD ----------
        System.out.println("Grand total via method: " + total(sales));
        System.out.println("Row 0 total via method: " + total(sales[0]));   // one row is an int[]
    }

    // Overloaded helpers: total of a whole 2D array, and of a single row
    public static int total(int[][] data) {
        int sum = 0;
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                sum += data[row][col];
            }
        }
        return sum;
    }

    public static int total(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return sum;
    }
}
