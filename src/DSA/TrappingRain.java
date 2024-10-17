package DSA;

public class TrappingRain {
    public static int getWater(int[] heights){
        int rain=0, max, amt;
        // Compute the suffix max
        int[] suffix = new int[heights.length];
        max = 0;
        for(int i=suffix.length-1;i>=0;i--){
            suffix[i] = max;
            max = (heights[i] > max)? heights[i]: max;
        }
        
        // Find the amount of water
        max = 0;
        for(int i=0;i<heights.length;i++){
            amt = Math.min(max, suffix[i]) - heights[i];
            if(amt > 0)
                rain+=amt;
            max = (heights[i] > max)? heights[i]: max;
    
        }
        System.out.println(rain);
        return rain;
    }
    public static void main(String[] args) {
        int[] heights = {4,2,0,3,2,5};
        getWater(heights);
    }
}
