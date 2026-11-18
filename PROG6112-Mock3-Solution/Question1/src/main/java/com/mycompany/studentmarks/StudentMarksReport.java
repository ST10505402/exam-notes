package com.mycompany.studentmarks;

/**
 * Q.1.1 - prints the student marks report using single and 2D arrays.
 */
public class StudentMarksReport {

    public static void main(String[] args) {
        // Single arrays: student names (rows) and assessment headings (columns)
        String[] students = {"Ayanda", "Brandon", "Chloe"};
        String[] assessments = {"TEST 1", "TEST 2", "EXAM"};

        // 2D array: [student][assessment]
        int[][] marks = {
            {72, 65, 80},   // Ayanda
            {45, 58, 49},   // Brandon
            {88, 91, 79}    // Chloe
        };

        StudentMarks studentMarks = new StudentMarks();
        String line = "-".repeat(45);

        System.out.println("STUDENT MARKS REPORT - PROG6112");
        System.out.println(line);

        // Column headings
        System.out.printf("%-10s", "");
        for (String assessment : assessments) {
            System.out.printf("%-8s", assessment);
        }
        System.out.println("AVERAGE");

        // One row per student: marks, then that student's average (one row = int[])
        for (int row = 0; row < marks.length; row++) {
            System.out.printf("%-10s", students[row]);
            for (int col = 0; col < marks[row].length; col++) {
                System.out.printf("%-8d", marks[row][col]);
            }
            System.out.printf("%.2f%n", studentMarks.StudentAverage(marks[row]));
        }
        System.out.println(line);

        // Summary for the whole class
        System.out.println("Highest mark:          " + studentMarks.HighestMark(marks));
        System.out.println("Lowest mark:           " + studentMarks.LowestMark(marks));
        System.out.println("Marks below " + StudentMarks.PASS_MARK + ":        "
                + studentMarks.CountBelowPassMark(marks, StudentMarks.PASS_MARK));
        System.out.println(line);
    }
}
