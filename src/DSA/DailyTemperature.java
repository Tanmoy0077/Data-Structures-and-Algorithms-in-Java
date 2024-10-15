package DSA;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    static class Temperature{
        int value;
        int index;
        Temperature(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    public static void getSolution(int[] temperatures){
        Stack<Temperature> stack = new Stack<>();
        int[] solution = new int[temperatures.length];
        for(int i=temperatures.length -1 ;i>=0;i--){
            while(!stack.isEmpty() && stack.peek().value <= temperatures[i])
                stack.pop();
            if(stack.isEmpty()){
                solution[i] = 0;
            }
            else{
                solution[i] = stack.peek().index - i;
            }
            Temperature temp = new Temperature(temperatures[i], i);
            stack.push(temp);
        }
        System.out.println(Arrays.toString(solution));
    }
    public static void main(String[] args) {
        int[] temperatures = {30,60,90};
        getSolution(temperatures);
    }
}
