package DSA;

public class HighestAltitude {
    public static void solver(int[] gain){
        int highest = 0, sum = 0;
        for(int i=0;i<gain.length;i++){
            sum += gain[i];
            highest = Math.max(highest, sum);
        }
        System.out.println(highest);
    }
    public static void main(String[] args) {
        int[] gain = {1,2,3,4,-10,-3,-2};
        solver(gain);
    }
}
