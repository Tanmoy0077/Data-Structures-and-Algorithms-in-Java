package DSA;

import java.util.*;

public class JumpGameII {
    public static int memorization(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[nums.length-1] = 0;
        return solver(nums, dp, 0);
    }
    public static int solver(int[] nums, int[] dp, int pos){
        if(dp[pos] != -1)
            return dp[pos];
        
        if(nums[pos] == 0){
            dp[pos] = 9999;
            return 9999;
        }

        int minJump = Integer.MAX_VALUE;
        for(int i=1;i<=nums[pos] && pos+i<nums.length;i++){
            if(dp[pos+i] == -1)
                solver(nums, dp, pos+i);
            minJump = Math.min(minJump, dp[pos+i]+1);
        }
        dp[pos] = minJump;
        return dp[pos];        
    }

    public static int tabulation(int[] nums){
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for(int i=nums.length-2;i>=0;i--){
            int minJump = 9999;
            for(int j=1;j<=nums[i] && i+j<nums.length;j++){
                minJump = Math.min(minJump, dp[i+j]+1);
            }
            dp[i] = minJump;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        // int result = memorization(nums);
        int result = tabulation(nums);
        System.out.println("Minimum jump required : "+result);
    }
}
