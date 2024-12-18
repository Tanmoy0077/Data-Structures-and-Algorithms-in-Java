package DSA;

public class SqrtX {
    public static int solver(int x){
        int left = 1, right = x/2, mid=0;
        if(x == 0 || x == 1)
            return x;
        while(left <= right){
            mid = (left+right)/2;
            int sq = x/mid;
            if(sq == mid)
                return mid;
            else if(sq > mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
    public static void main(String[] args) {
        int x = 2;
        // int x = 19;
        int result = solver(x);
        System.out.println("Square root of "+x+" is : "+result);
    }
}
