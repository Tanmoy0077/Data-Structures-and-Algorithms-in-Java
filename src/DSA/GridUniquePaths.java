package DSA;

public class GridUniquePaths {
    public static int findUniquePaths(int mat[][], int i, int j){
        int m = mat.length, n = mat[0].length;
        if(i == m-1 && j == n-1)
            return 1;
        int count = 0;
        if(i+1 < m){
            if(mat[i+1][j] < 0)
                count = findUniquePaths(mat, i+1, j);
            else
                count = mat[i+1][j];
        }
        if(j+1 < n){
            if(mat[i][j+1] < 0)
                count += findUniquePaths(mat, i, j+1);
            else
                count += mat[i][j+1];
        }
        mat[i][j] = count;
        return count;
    }

    public static int uniquePaths(int m, int n){
        int[][] mat = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = -1;
            }
        }
        return findUniquePaths(mat, 0, 0);
    }
    public static void main(String[] args) {
        System.out.println("Number of Unique Paths : "+uniquePaths(4, 4));
    }
}
