package com.mycompany.studentmarks;

/**
 * Q.1.2 - all calculations for the student marks report.
 */
public class StudentMarks implements IStudentMarks {

    public static final int PASS_MARK = 50;    // stored as a constant, as required

    // Average of one student's marks (one row); cast to double before dividing
    @Override
    public double StudentAverage(int[] studentMarks) {
        if (studentMarks.length == 0) {
            return 0;
        }
        int total = 0;
        for (int mark : studentMarks) {
            total += mark;
        }
        return (double) total / studentMarks.length;
    }

    // Highest single mark in the whole 2D array; start from a real element
    @Override
    public int HighestMark(int[][] marks) {
        int highest = marks[0][0];
        for (int[] student : marks) {
            for (int mark : student) {
                if (mark > highest) {
                    highest = mark;
                }
            }
        }
        return highest;
    }

    // Lowest single mark in the whole 2D array
    @Override
    public int LowestMark(int[][] marks) {
        int lowest = marks[0][0];
        for (int[] student : marks) {
            for (int mark : student) {
                if (mark < lowest) {
                    lowest = mark;
                }
            }
        }
        return lowest;
    }

    // Number of marks strictly below the pass mark (50 itself is a pass)
    @Override
    public int CountBelowPassMark(int[][] marks, int passMark) {
        int count = 0;
        for (int[] student : marks) {
            for (int mark : student) {
                if (mark < passMark) {
                    count++;
                }
            }
        }
        return count;
    }
}
