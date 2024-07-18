package DSA;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};
        // Finding the element to swap
        int pivot=-1, target=arr.length-1, temp;
        for(int i=arr.length-1;i>0;i--){
            if(arr[i-1] < arr[i]){
                pivot = i-1;
                break;
            }
        }
        // If pivot found then finding the target element to be swapped
        if(pivot>=0){
            for(int i=arr.length-1;i>=0;i--){
                if(arr[i]>arr[pivot]){
                    target = i;
                    break;
                }
            }
            // Swap the pivot with target
            temp = arr[pivot];
            arr[pivot] = arr[target];
            arr[target] = temp;
        }
        // Reverse the array after the pivot element
        int i = pivot + 1;
        target = arr.length-1;
        while(i<target){
            temp = arr[target];
            arr[target] = arr[i];
            arr[i] = temp;
            i++;
            target--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
