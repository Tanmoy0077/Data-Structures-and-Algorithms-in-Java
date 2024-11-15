package DSA;

import java.util.*;

class Pair{
    TreeNode node;
    int currMax;

    Pair(TreeNode node, int currMax){
        this.node = node;
        this.currMax = currMax;
    }
}
public class GoodNodes {
    public static void bfs(TreeNode root){
        int count = 0, cmax;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, root.val));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if(p.node.val >= p.currMax){
                count++;
            }
            cmax = Math.max(p.node.val, p.currMax);
            if(p.node.left != null)
                queue.add(new Pair(p.node.left, cmax));
            if(p.node.right != null)
                queue.add(new Pair(p.node.right, cmax));
        }
        System.out.println(count);
    }

    public static void driver(TreeNode root){
        int count = dfs(root, root.val);
        System.out.println("The number of good nodes are : "+count);
    }

    public static int dfs(TreeNode root, int currMax){
        if(root != null){
            int count = 0;
            if(root.val >= currMax){
                count++;
                currMax = root.val;
            }
            count += dfs(root.left, currMax);
            count += dfs(root.right, currMax);
            return count;
        }
        return 0;
    }
    public static void main(String[] args) {
        
    }
}
