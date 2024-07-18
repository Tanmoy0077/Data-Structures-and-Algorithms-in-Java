package DSA;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class FourSum {
    public static List<List<Integer>> getFourSum(int[] arr, int target){
        List<List<Integer>> solution = new ArrayList<>();
        Arrays.sort(arr);

        int i, j, k, l;
        long sum;
        for(i=0;i<arr.length;i++){
            if(i != 0 && arr[i] == arr[i-1])
                continue;
            for(j=i+1;j<arr.length;j++){
                if(j != i+1 && arr[j] == arr[j-1])
                    continue;
                k = j+1;
                l = arr.length-1;
                while(k<l){
                    sum = (long)arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum == target){
                        solution.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while(k<l && arr[k] == arr[k-1])
                            k++;
                        while(k<l && arr[l] == arr[l+1])
                            l--;
                    }
                    else if(sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }
        return solution;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target value : ");
        int target = sc.nextInt();
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        System.out.println("Enter "+n+" values : ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        List<List<Integer>> ans = getFourSum(arr, target);
        System.out.println("The solution is : ");
        System.out.println(ans);
    }
}
