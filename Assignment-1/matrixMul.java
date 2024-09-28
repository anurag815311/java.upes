import java.util.Scanner;

public class matrixMul {

    // Method to multiply two matrices
    public static int[][] multiplyMatrices(int[][] X, int[][] Y, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    result[i][j] += X[i][k] * Y[k][j];
                }
            }
        }
        return result;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Method to check if two matrices are equal
    public static boolean areMatricesEqual(int[][] A, int[][] B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 4;

        // Input matrices A and B
        int[][] A = new int[size][size];
        int[][] B = new int[size][size];

        System.out.println("Enter elements for matrix A (4x4):");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements for matrix B (4x4):");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Compute AB and BA
        int[][] AB = multiplyMatrices(A, B, size);
        int[][] BA = multiplyMatrices(B, A, size);

        System.out.println("Matrix AB:");
        printMatrix(AB);

        System.out.println("Matrix BA:");
        printMatrix(BA);

        // Check if AB = BA
        if (areMatricesEqual(AB, BA)) {
            System.out.println("AB is equal to BA");
        } else {
            System.out.println("AB is not equal to BA");
        }
        sc.close();
    }
}
