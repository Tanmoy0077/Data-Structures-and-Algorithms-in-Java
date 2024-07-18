package DSA;

import java.util.Scanner;

public class IntToRoman {
    public static void main(String[] args) {
        int[] romanValues = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romanLetters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        sc.close();
        int i = 0;
        while (n != 0) {
            if (n >= romanValues[i]) {
                result.append(romanLetters[i]);
                n = n - romanValues[i];
            } else
                i++;
        }
        System.out.println("The Roman Numeral is : " + result);
    }
}
