package DSA;

import java.util.Stack;

public class StackConversion {
    public static char[] operators = { '+', '-', '*', '/', '(', ')', '^' };

    public static String getPostfix(String str) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!isOperator(str.charAt(i)))
                result.append(str.charAt(i));
            else {
                if (str.charAt(i) == '(')
                    stack.push(str.charAt(i));
                else if (str.charAt(i) == ')') {
                    while ((!stack.isEmpty()) && (stack.peek() != '(')) {
                        result.append(stack.pop());
                    }
                    stack.pop();
                } else {
                    if ((stack.isEmpty()) || (getPrecedence(stack.peek()) < getPrecedence(str.charAt(i)))) {
                        stack.push(str.charAt(i));
                    } else {
                        while ((!stack.isEmpty()) && (getPrecedence(stack.peek()) >= getPrecedence(str.charAt(i)))) {
                            result.append(stack.pop());
                        }
                        stack.push(str.charAt(i));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void getPrefix(String str) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        

    }

    public static int getPrecedence(char c) {
        if (c == '^')
            return 3;
        else if ((c == '*') || (c == '/'))
            return 2;
        else
            return 1;
    }

    public static boolean isOperator(char op) {
        for (char operator : operators) {
            if (operator == op) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getPostfix("a+b-(c*e)"));
    }
}
