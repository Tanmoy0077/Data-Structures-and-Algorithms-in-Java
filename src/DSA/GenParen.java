package DSA;

import java.util.Stack;

class Solver {
    int openCount, size;
    Stack<String> stack;
    String[] arr;

    Solver(int n) {
        openCount = n;
        size = 2 * n;
        stack = new Stack<>();
        arr = new String[size];
    }

    void displayParen(int n) {
        if (n == size) {
            arr[n - 1] = stack.peek();
            for(String str: arr)
                System.out.print(str);
            System.out.println();
            return;
        } 
        if (openCount > 0) {
            stack.push(")");
            arr[n - 1] = "(";
            openCount--;
            displayParen(n + 1);
            openCount++;
            stack.pop();
        }
        if (!stack.isEmpty()) {
            arr[n - 1] = stack.pop();
            displayParen(n + 1);
            stack.push(")");
        }
    }
}

public class GenParen {
    public static void main(String[] args) {
        Solver s = new Solver(8);
        s.displayParen(1);
    }
}
