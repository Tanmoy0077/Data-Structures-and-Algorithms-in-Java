package DSA;

public class PivotIndex {
    public static void solver(int[] nums){
        int rightSum = 0,sum = 0, i;
        for(i=0;i<nums.length;i++){
            rightSum+= nums[i];
        }
        for(i=0;i<nums.length;i++){
            rightSum -= nums[i];
            if(sum == rightSum){
                System.out.println("Pivot index is : "+i);
                break;
            }
            sum += nums[i];
        }
        if(i < 0){
            System.out.println("No pivot index");
        }
    }
    public static void main(String[] args) {
        int[] nums = {-1,-1,0,0,-1,-1};
        solver(nums);
    }
}
