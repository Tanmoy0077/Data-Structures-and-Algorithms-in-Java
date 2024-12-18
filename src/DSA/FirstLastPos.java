package DSA;

public class FirstLastPos {
    public static int[] searchRange(int[] nums, int target){
        int left=0, right=nums.length-1, mid, pos=-1;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        while (left <= right) {
            mid = (left+right)/2;
            if(nums[mid] >= target){
                pos = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        if(pos == -1 || nums[pos] != target){
            return result;
        }

        result[0] = pos;
        result[1] = pos;
        
        left = pos;
        right = nums.length-1;
        pos = -1;
        
        while(left <= right){
            mid = (left+right)/2;
            if(nums[mid] > target){
                pos = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        if(pos == -1)
            pos = nums.length;

        result[1] = pos - 1;

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {5,5,5,5,6,7,9,9,9};
        int target = 9;
        int[] result = searchRange(arr, target);
        System.out.println(result[0]+" "+result[1]);
    }
}
