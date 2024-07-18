package DSA;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> solution = new ArrayList<>();
        int i, j, k, sum;
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter "+n+" numbers :");
        for(i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the target element : ");
        int target = sc.nextInt();
        sc.close();

        Arrays.sort(arr);
        
        for(i=0;i<n;i++){
            if(i != 0 && arr[i-1] == arr[i]){
                continue;
            }
            j = i+1;
            k = n-1;
            while (j < k) {
                sum = arr[i]+arr[j]+arr[k];
                if(sum == target){
                    solution.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while(j < k && arr[j-1] == arr[j])
                        j++;
                    while(j<k && arr[k] == arr[k+1])
                        k--;
                }
                else if(sum < target){
                    j++;
                }
                else{
                    k--;
                }
                
            }

        }
        System.out.println("The values are : ");
        System.out.println(solution);

    }
}
