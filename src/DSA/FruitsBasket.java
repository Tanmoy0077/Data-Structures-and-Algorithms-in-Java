package DSA;

import java.util.HashMap;

public class FruitsBasket {
    public static void getMaxFruits(int[] tree) {
        HashMap<Integer, Integer> fruitsPos = new HashMap<>();
        int left = 0, right=0, maxLength=0, oldVal;
        while (right < tree.length){
            if (fruitsPos.size() < 2 && !fruitsPos.containsKey(tree[right]))
                fruitsPos.put(tree[right], right);
            else if (fruitsPos.size() == 2 && !fruitsPos.containsKey(tree[right])){
                oldVal = tree[left];
                left = fruitsPos.get(tree[left]) + 1;
                fruitsPos.remove(oldVal);
                fruitsPos.put(tree[right], right);
            }
            else
                fruitsPos.replace(tree[right], right);
            
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        System.out.println("Maximum fruits can be : "+maxLength);
    }
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 2, 1, 1, 1, 2, 3, 3, 4};
        getMaxFruits(arr);
    }
}
