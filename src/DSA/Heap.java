package DSA;

import java.util.Scanner;
import java.util.Arrays;
class MaxHeap {
    int n;
    int[] arr;

    MaxHeap(int[] arr) {
        this.n = arr.length;
        this.arr = new int[this.n+1];
        for (int i = 1; i <= this.n; i++)
            this.arr[i] = arr[i - 1];
        buildMaxHeap();
    }

    void heapify(int i, int n) {
        int l = i * 2;
        int r = i * 2 + 1;
        int max = i;
        if (l <= n && this.arr[l] > this.arr[i])
            max = l;
        if (r <= n && this.arr[r] > this.arr[max])
            max = r;
        if (max != i) {
            int temp = this.arr[max];
            this.arr[max] = this.arr[i];
            this.arr[i] = temp;
            heapify(max, n);
        }
    }

    void buildMaxHeap(){
        for(int i=this.n/2;i>=1;i--){
            heapify(i, this.n);
        }
    }
    int getMax(){
        return this.arr[1];
    }
    int popMax(){
        int result = this.arr[1];
        this.arr[1] = Integer.MIN_VALUE;
        heapify(1, n);
        return result;
    }

}

public class Heap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the values : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        MaxHeap m = new MaxHeap(arr);
        System.out.println(m.getMax());
        System.out.println(m.popMax());
        System.out.println(m.popMax());
        System.out.println(m.popMax());
        System.out.println(m.popMax());
        System.out.println(m.popMax());
        System.out.println(m.popMax());
        System.out.println(m.popMax());
        System.out.println(m.popMax());
        System.out.println(m.popMax());
        System.out.println(m.popMax());
        
        System.out.println(Arrays.toString(m.arr));
    }
}
/* 
 * Test Case
 * n = 10
 * arr = 1 4 2 3 9 7 8 10 14 16
 */