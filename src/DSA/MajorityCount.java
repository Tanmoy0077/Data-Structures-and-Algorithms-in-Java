package DSA;

import java.util.Scanner;

public class MajorityCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int majorityCount = 0, major = 0;
        for(int i=0;i<n;i++){
            if(majorityCount == 0)
                major = arr[i];
            if(arr[i] == major)
                majorityCount++;
            else
                majorityCount--;
                
        }
        System.out.println("The majority element is : "+major);
    }
}
