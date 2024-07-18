package DSA;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallest {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        };
        PriorityQueue<Integer> p = new PriorityQueue<Integer>(comparator);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of K : ");
        int k = sc.nextInt();
        if (k > n) {
            System.out.println("Invalid value of K");
            System.exit(0);
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            p.add(arr[i]);
            if (i > k - 1)
                p.poll();
        }
        System.out.println("Kth smallest element is : " + p.peek());
    }
}