package DSA;

import java.text.DecimalFormat;

public class AverageSubarray {
    public static void solver(int nums[], int k){
        int left = 1, sum = 0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        double maxAvg = (double)sum/k;
        sum -= nums[0];
        for(int i=k;i<nums.length;i++){
            sum += nums[i];
            maxAvg = Math.max((double)sum/k, maxAvg);
            sum -= nums[left];
            left++;
        }
        DecimalFormat df = new DecimalFormat("#.#####");
        System.out.println(df.format(maxAvg));
    }
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        solver(nums, k);
    }
}
