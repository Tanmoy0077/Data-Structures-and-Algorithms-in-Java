package DSA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterI {
    public static void getSolution(int[] nums1, int[] nums2){
        Stack<Integer> stack = new Stack<>();
        int[] nele = new int[nums2.length];
        int[] solution = new int[nums1.length];
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i])
                stack.pop();
            if(stack.isEmpty()){
                nele[i] = -1;
                stack.push(nums2[i]);
            }
            else if(nums2[i] < stack.peek()){
                nele[i] = stack.peek();
                stack.push(nums2[i]);
            }
            hash.put(nums2[i], i);
        }
        for(int i=0;i<nums1.length;i++){
            if(hash.containsKey(nums1[i])){
                solution[i] = nele[hash.get(nums1[i])];
            }

        }
        System.out.println(Arrays.toString(solution));

    }
    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        getSolution(nums1, nums2);
    }
}
