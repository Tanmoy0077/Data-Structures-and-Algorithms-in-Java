package DSA;

public class TrappingRain {
    public static int getWater(int[] heights){
        int rain = 0, n = heights.length, leftMax=heights[0], rightMax=heights[n-1];
        int i = 0, j = n-1;
        while(i<j){
            if(leftMax <= rightMax){
                i++;
                leftMax = Math.max(leftMax, heights[i]);
                rain += leftMax - heights[i];
            }
            else{
                j--;
                rightMax = Math.max(rightMax, heights[i]);
                rain += rightMax - heights[i];
            }
        }
        return rain;
    }
    public static void main(String[] args) {
        
    }
}
