package DSA;

import java.util.Scanner;
import java.util.Arrays;

public class MajorityCount2 {
    public static int[] majority(int[] arr){
        int[] major = new int[2];
        major[0] = -999;
        major[1] = -999;
        int count1 = 0, count2 = 0;
        for(int i=0;i<arr.length;i++){
            if(count1 == 0 && major[1] != arr[i]){
                count1++;
                major[0] = arr[i];
            }
            else if(count2 == 0 && major[0] != arr[i]){
                count2++;
                major[1] = arr[i];
            }
            else if(arr[i] == major[0])
                count1 ++;
            else if(arr[i] == major[1])
                count2++;
            else{
                count1--;
                count2--;
            }
        }
        if(count1 > count2){
            major[1] = -1;
        }
        else{
            major[0] = -1;
        }
        return major;
    }
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
        System.out.println("The Majority elements are : ");
        System.out.println(Arrays.toString(majority(arr)));
    }
}
