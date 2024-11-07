package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void solver(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();

        int count = 0;
        for(int element: asteroids){
            if(element > 0)
                stack.push(element);
            else{
                while(!stack.isEmpty() && stack.peek() < Math.abs(element))
                    stack.pop();
                if(stack.isEmpty()){
                    count++;
                    arr.add(element);
                }
                else if(stack.peek() == Math.abs(element))
                    stack.pop();
            }
        }
        int point = count;
        int temp;
        while(!stack.isEmpty()){
            arr.add(stack.pop());
            count++;
        }
        int[] result = arr.stream().mapToInt(Integer::intValue).toArray();
        count--;
        while(point < count){
            temp = result[point];
            result[point] = result[count];
            result[count] = temp;
            point++;
            count--;
        }

        System.out.println(Arrays.toString(result));

    }
    public static void main(String[] args) {
        int[] asteroids = {10, 7, 6, 5, -5, -6, -7, -10};
        solver(asteroids); 
    }
}
