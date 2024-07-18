package DSA;

public class MatrixRotation {
    public static void transpose(int[][] arr, int n) {
        int i, j, temp;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    public static void colReverse(int[][] arr, int n) {
        int i, j, temp, row = 0;
        while (row < n) {
            i = 0;
            j = n - 1;
            while (i < j) {
                temp = arr[row][i];
                arr[row][i] = arr[row][j];
                arr[row][j] = temp;
                i++;
                j--;
            }
            row++;
        }
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        
        System.out.println("Before : ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        // 90 degree right rotation
        transpose(mat, mat.length);
        colReverse(mat, mat.length);

        System.out.println("After : ");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
