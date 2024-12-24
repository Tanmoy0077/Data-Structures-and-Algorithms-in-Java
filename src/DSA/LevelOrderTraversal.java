package DSA;

import java.util.*;

public class LevelOrderTraversal {
    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        List<Integer> sol = new ArrayList<>();
        int currLevel = 0;
        if (root == null)
            return result;
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair item = queue.poll();
            if (currLevel < item.level) {
                if (currLevel % 2 != 0)
                    Collections.reverse(sol);
                result.add(sol);
                sol = new ArrayList<>();
                currLevel++;
            }

            sol.add(item.node.val);

            if (item.node.left != null)
                queue.add(new Pair(item.node.left, item.level + 1));
            if (item.node.right != null)
                queue.add(new Pair(item.node.right, item.level + 1));
        }
        
        if (!sol.isEmpty())
            if(currLevel%2!=0)
                Collections.reverse(sol);
            result.add(sol);
        return result;
    }

    public static void main(String[] args) {

    }
}
