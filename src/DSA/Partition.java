package DSA;

import java.util.Arrays;
import java.util.Scanner;

public class Partition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the pivot index : ");
        int k = sc.nextInt();
        sc.close();
        int i = 0, j = arr.length-1, pivot = arr[k], temp;
        while(i<j){
            while(arr[i]<=pivot && i<arr.length)
                i++;
            while(arr[j]>pivot && j>0)
                j--;
            if(i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
        System.out.println("The array is : "+Arrays.toString(arr));
    }
}
