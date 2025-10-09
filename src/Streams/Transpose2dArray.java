package Streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Transpose2dArray {
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Transpose the matrix
        int[][] transposedMatrix = transpose(matrix);

        // Print the transposed matrix
        System.out.println("Transposed Matrix:");
        for (int[] row : transposedMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] transpose(int[][] matrix) {
        // Transpose logic using streams
        return IntStream.range(0, matrix[0].length) // Iterate over columns
                .mapToObj(col -> IntStream.range(0, matrix.length) // Iterate over rows
                        .map(row -> matrix[row][col]) // Collect column elements
                        .toArray())
                .toArray(int[][]::new); // Convert to 2D array
    }

//    public static void rotate(int[][] matrix) {
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        // step1: transpose the matrix
//        for (int i = 0; i < n-1; i++)
//        {
//            for (int j = i + 1; j < m; j++)
//            {
//                swap(matrix, i, j);
//            }
//        }
//        for (int i = 0; i < n; i++)
//        {
//            int[] arr = matrix[i];
//        }
//
//    }
//
//    public static void swap(int[][] matrix, int i, int j)
//    {
//        int temp = matrix[i][j];
//        matrix[i][j] = matrix[j][i];
//        matrix[j][i] = temp;
//    }
}
