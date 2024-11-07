package DSA;

import java.util.*;

public class UniqueOccurrences {
    public static boolean solver(int[] arr){
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int element: arr){
            if(!freq.containsKey(element))
                freq.put(element, 0);
            freq.put(element, freq.get(element)+1);
        }
        for(Map.Entry<Integer, Integer> item: freq.entrySet()){
            if(set.contains(item.getValue()))
                return false;
            set.add(item.getValue());
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(solver(arr));
    }
}
