package DSA;

import java.util.*;

public class KSumPairs {
    public static void solver(int[] nums, int k){
        HashMap<Integer, Integer> hash = new HashMap<>();
        int count = 0, min;

        for(int n: nums){
            if(!hash.containsKey(n))
                hash.put(n, 0);
            hash.put(n, hash.get(n)+1);
        }
        Set<Integer> keys = hash.keySet();
        for(Integer element: keys){
            if(element*2 == k && hash.get(element) > 1){
                count += hash.get(element) / 2;
                hash.put(element, hash.get(element) % 2); 
            }
            else if(hash.containsKey(k - element) && hash.get(k - element) > 0 && element != k - element){
                // Conditions
                // If the element exists in the array
                // And its frequency is greater than 0
                // And it is not the same element
                min = Math.min(hash.get(element), hash.get(k - element));
                count += min;
                hash.put(k - element, hash.get(k - element) - min);
                hash.put(element, hash.get(element) - min);
            }
        }
        System.out.println(count);
    }
    // Another approach is to sort the array and use two pointers to find the sum

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,7};
        int k = 8;
        solver(nums, k);
    }
}
