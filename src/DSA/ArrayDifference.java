package DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArrayDifference {
    public static void solver(int[] nums1, int[] nums2){
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        List<Integer> store = new ArrayList<>();
        List<List<Integer>> solution = new ArrayList<>();

        for(int element: nums1){
            a.add(element);
        }
        for(int element: nums2){
            b.add(element);
        }
        for(int element: a){
            if(!b.contains(element))
                store.add(element);
        }
        solution.add(store);
        store = new ArrayList<>();
        for(int element: b){
            if(!a.contains(element))
                store.add(element);
        }
        solution.add(store);
        System.out.println(solution);

    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {3,2,6};
        solver(nums1, nums2);
    }
}
