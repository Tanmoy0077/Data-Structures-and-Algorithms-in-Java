package DSA;

import java.util.Arrays;
import java.util.Scanner;

public class Sort012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter 0, 1 or 2 : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int low = 0, high=arr.length-1, temp, i=0;
        while (i<=high) {
            if(arr[i] == 0){
                temp = arr[i];
                arr[i++] = arr[low];
                arr[low++] = temp;
            }
            else if(arr[i] == 2){
                temp = arr[i];
                arr[i] = arr[high];
                arr[high--] = temp;
            }
            else
                i++;
        }
        System.out.println("After sorting the array is : "+Arrays.toString(arr));
    }
}
