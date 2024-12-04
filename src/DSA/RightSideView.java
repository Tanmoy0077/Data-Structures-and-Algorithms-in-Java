package DSA;

import java.util.*;

public class RightSideView {
    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    private static List<Integer> solver(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Pair> queue = new LinkedList<>();

        Pair prev = new Pair(root, 0);
        queue.add(prev);

        while(!queue.isEmpty()){
            Pair item = queue.poll();
            if(item.level > prev.level){
                result.add(prev.node.val);
            }
            if(item.node.left != null)
                queue.add(new Pair(item.node.left, item.level+1));
            if(item.node.right != null)
                queue.add(new Pair(item.node.right, item.level+1));
            prev = item;
        }
        result.add(prev.node.val);
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        solver(root);
    }
}
