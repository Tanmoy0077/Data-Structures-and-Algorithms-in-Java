package DSA;

import java.util.Scanner;
import java.util.HashMap;

public class ZeroSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements in the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        HashMap<Integer, Integer> h = new HashMap<>();
        int maxLen = 0, temp, sum = 0;
        h.put(0, 0);
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (h.containsKey(sum)) {
                temp = i - h.get(sum) + 1;
                maxLen = (maxLen < temp) ? temp : maxLen;
            } else
                h.put(sum, i + 1);
        }
        System.out.println("Maximum length of subarray with zero sum is : " + maxLen);
    }
}