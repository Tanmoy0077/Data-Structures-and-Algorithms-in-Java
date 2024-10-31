package DSA;

import java.util.Arrays;

public class MoveZeros {
    public static void solver(int[] nums){
        int j=0, temp;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                while((j <= i) || (j < nums.length && nums[j] == 0))
                    j++;
                if(j < nums.length){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
        
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,3,0,0,2};
        solver(nums);
    }
}
