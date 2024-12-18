package DSA;

public class LowerBound {
    // Task is to find the smallest index which satisfies arr[i] >= k
    public static void solver(int[] arr, int k){
        int left = 0, right = arr.length-1, mid;
        int lowerBound = arr.length;
        while(left <= right){
            mid  = (left + right)/2;
            // mid is a valid index
            if(arr[mid] >= k){
                lowerBound = mid;
                // search for a lower index
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        System.out.println(lowerBound);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,7,8,9,9,9,11};
        solver(arr, 0);
    }
    
}
