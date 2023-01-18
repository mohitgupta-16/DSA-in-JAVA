import java.util.*;

public class Array3 {

    static boolean subArrayWithZeroSum(int a[]) {
        int n = a.length;
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    static void transposeOfMatrix(int a[][]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int swap = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = swap;
            }
        }
    }

    static void printMatrix(int a[][]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void rotateMatrixBy90(int a[][]) {
        int n = a.length;
        transposeOfMatrix(a);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int swap = a[i][j];
                a[i][j] = a[i][n - j - 1];
                a[i][n - j - 1] = swap;
            }
        }
    }

    static void searchInSortedMatrix(int a[][], int key) {
        int row = 0;
        int col = a.length - 1;
        while (row < a.length && col >= 0) {
            if (a[row][col] == key) {
                System.out.println("Indices: " + row + "," + col);
                return;
            } else if (a[row][col] > key) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Not Found");
    }

    public static void main(String args[]) {

        // // subarray with zero sum
        // int arr[] = { 2, 3, 1, -4, 4, -2 };
        // System.out.println(subArrayWithZeroSum(arr));

        // // transpose of a matrix
        // int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
        // 15, 16 } };
        // printMatrix(arr);
        // transposeOfMatrix(arr);

        // // rotate matrix by 90 clockwise
        // rotateMatrixBy90(arr);
        // printMatrix(arr);

        // search for a element in a row and column wise matrix
        int arr[][] = { { 1, 4, 5, 7 }, { 2, 5, 6, 9 }, { 6, 10, 11, 13 } };
        int key = 10;
        searchInSortedMatrix(arr, key);
    }
}
