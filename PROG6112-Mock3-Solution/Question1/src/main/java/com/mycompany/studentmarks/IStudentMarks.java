package com.mycompany.studentmarks;

/**
 * Q.1.2 - interface exactly as given in the paper.
 */
public interface IStudentMarks {
    double StudentAverage(int[] studentMarks);
    int HighestMark(int[][] marks);
    int LowestMark(int[][] marks);
    int CountBelowPassMark(int[][] marks, int passMark);
}
