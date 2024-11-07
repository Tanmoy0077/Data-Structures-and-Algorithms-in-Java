package DSA;

import java.util.*;

public class RowColumnPair {
    public static int[] getColumn(int[][] mat, int index){
        int[] column = new int[mat.length];
        for(int i=0;i<column.length;i++){
            column[i] = mat[i][index];
        }
        return column;
    }
    public static void solver(int[][] grid) {
        int count = 0;
        for(int[] row: grid){
            for(int i=0;i<grid[0].length;i++){
                if(Arrays.equals(row, getColumn(grid, i))){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1},{3,32}};
        solver(grid);
    }
}
