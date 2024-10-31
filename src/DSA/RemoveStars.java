package DSA;

import java.util.Stack;

public class RemoveStars {
    public static void solver(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c: chars){
            if(c == '*' && !stack.isEmpty())
                stack.pop();
            else
                stack.push(c);
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb.reverse().toString());
    }
    public static void main(String[] args) {
        String s = "erase*****";
        solver(s);
    }
}
