package DSA;

public class MaxOnesIII {
    public static void solver(int[] nums, int k){
        int zCount = 0, maxOnes=0, left=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
                zCount++;
            if(zCount > k){
                while(nums[left] != 0)
                    left++;
                zCount --;
                left++;
            }
            maxOnes = Math.max(i - left + 1, maxOnes);
        }
        System.out.println(maxOnes);
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,0,0,0,1,1,1,1};
        int k = 0;
        solver(nums, k);
    }
}
