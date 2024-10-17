package DSA;

import java.util.Stack;

public class RemoveKDigits {
    public static String getSolution(String num, int k){
        // Base cases
        if(k == 0)
            return num;
        if(k > num.length())
            return "0";

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            int digit = Character.digit(num.charAt(i), 10);
            while(!stack.isEmpty() && stack.peek() > digit && k>0){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        // If the digits are in ascending order
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while(!stack.empty()){
            result.append(stack.pop());
        }
        // Remove the leading 0s
        num = result.reverse().toString().replaceFirst("^0*", "");
        if(num.isEmpty())
            return "0";
        return num;
    }
    public static void main(String[] args) {
        String num = "12";
        int k = 2;
        System.out.println(getSolution(num, k));
    }
}
