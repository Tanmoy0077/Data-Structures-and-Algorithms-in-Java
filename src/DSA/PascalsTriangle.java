package DSA;

import java.util.Scanner;

public class PascalsTriangle{
    public static int nCr(int n, int r){
        int result = 1;
        for(int i=0;i<r;i++){
            result = (result * (n - i))/(i+1);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows : ");
        int row = sc.nextInt();
        sc.close();
        System.out.println("The Pascal's Triangle :");
        for(int i=0;i<row;i++){
 
            for(int j=row;j>i;j--){
                System.out.print(" ");
            }

            for(int j=0;j<i+1;j++){
                System.out.print(nCr(i, j)+" ");
            }

            System.out.println();
        }
    }
}