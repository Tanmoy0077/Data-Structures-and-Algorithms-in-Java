package DSA;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterII {
    public static void getSolution(int[] nums){
        int[] solution = new int[nums.length];
        Stack<Integer> stack =  new Stack<>();
        for(int i = nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() < nums[i])
                stack.pop();
            stack.push(nums[i]);
        }
        for(int i = nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            if(stack.isEmpty()){
                solution[i] = -1;
            }
            else{
                solution[i] = stack.peek();  
            }
            stack.push(nums[i]); 
        }
        System.out.println(Arrays.toString(solution));
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        getSolution(nums);
    }
}
