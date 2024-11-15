package DSA;

import java.util.*;

public class LeafSimilarTrees{
    public static void solver(TreeNode root1, TreeNode root2){
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        dfs(root1, left);
        dfs(root2, right);
        if(left.equals(right)){
            System.out.println("Trees are similar");
        }
        else{
            System.out.println("Trees are not similar");
        }
    }

    public static void dfs(TreeNode root, List<Integer> leafs){
        if(root != null){
            if(root.left == null && root.right == null){
                leafs.add(root.val);
            }
            dfs(root.left, leafs);
            dfs(root.right, leafs);
        }
    }
    public static void main(String[] args){

    }
}