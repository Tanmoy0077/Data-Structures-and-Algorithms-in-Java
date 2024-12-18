package DSA;

import java.util.*;

public class MaxLevelSum {
    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public static int solver(TreeNode root){
        Queue<Pair> queue = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE, maxLevel=0;
        int sum = 0, prevLevel = 1;

        queue.add(new Pair(root, prevLevel));
        while(!queue.isEmpty()){
            Pair item = queue.poll();
            if(item.level > prevLevel){
                if(maxSum < sum){
                    maxSum = sum;
                    maxLevel = prevLevel;
                }
                sum = 0;
            }
            sum += item.node.val;
            if(item.node.left != null)
                queue.add(new Pair(item.node.left, item.level+1));
            if(item.node.right != null)
                queue.add(new Pair(item.node.right, item.level+1));

            prevLevel = item.level;
        }
        
        if(maxSum < sum){
            maxSum = sum;
            maxLevel = prevLevel;
        }

        return maxLevel;
    }
    public static void main(String[] args) {
        
    }
}
