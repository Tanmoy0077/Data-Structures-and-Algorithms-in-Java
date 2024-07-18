package DSA;

import java.util.Scanner;

public class ReversePairs {
    public static int merge(int arr[], int left, int mid, int right) {
        int count = 0;
        int temp[] = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }
        i = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] > (long)2*arr[j]) {
                j++;
            } else {
                count += j - (mid+ 1);
                i++;
            }
        }
        while(i<=mid){
            count+= right - mid;
            i++;
        }
        k = 0;
        for (i = left; i <= right; i++) {
            arr[i] = temp[k++];
        }
        return count;
    }

    public static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("The Number of Reverse Pairs : " + mergeSort(arr, 0, n - 1));
    }
}
/*
 * [2147483647 2147483647 -2147483647 -2147483647 -2147483647 2147483647]
 */