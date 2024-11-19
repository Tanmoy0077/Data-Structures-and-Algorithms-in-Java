package DSA;

import java.util.*;

public class PathSumIII {
    // ! How to hash a node ?
    // public static HashMap<TreeNode, Integer> hash = new HashMap<>();
    // public int pathSum(TreeNode root, int target) {
    //     if(root == null){
    //         return 0;
    //     }
    //     int count = 0;
    //     if(Long.valueOf(root.val).equals(Long.valueOf(target))){
    //         count++;
    //     }
    //     hash.put(root, 0);
    //     dfs(root.left, root, (long)root.val, target);
    //     dfs(root.right, root, (long)root.val, target);
    //     for(Map.Entry<TreeNode, Integer> element: hash.entrySet()){
    //         TreeNode t = element.getKey();
    //         System.out.println(t.hashCode()+" -- "+element.getValue());
    //         count += element.getValue();
    //     }
    //     return count;
    // }
    // public static void dfs(TreeNode root, TreeNode parent, long parentSum, int target){
    //     if(root == null){
    //         return;
    //     }
    //     if(!hash.containsKey(root)){
    //         hash.put(root, 0);
    //         dfs(root.left, root, root.val, target);
    //         dfs(root.right, root, root.val, target);
    //         if(Long.valueOf(root.val).equals(Long.valueOf(target))){
    //             hash.put(root, hash.get(root)+1);
    //         }
    //     }
    //     if(Long.valueOf(root.val+parentSum).equals(Long.valueOf(target))){
    //         hash.put(parent, hash.get(parent)+1);
    //     }
    //     dfs(root.left, parent, parentSum+root.val, target);
    //     dfs(root.right, parent, parentSum+root.val, target);
    // }
    private static HashMap<Long, Integer> hash = new HashMap<>();
    private static int totalCount;
    
    public static int pathSum(TreeNode root, int targetSum){
        hash.put(0L, 1);
        totalCount = 0;
        dfs(root, 0L, targetSum);
        return totalCount;
    }
    public static void dfs(TreeNode root, long currentSum, int targetSum){
        if(root != null){
            long sum = root.val + currentSum;
            
            if(hash.containsKey(sum - targetSum)){
                totalCount += hash.get(sum - targetSum);
            }
            if(!hash.containsKey(sum))
                hash.put(sum, 0);
            hash.put(sum, hash.get(sum)+1);
            
            dfs(root.left, sum, targetSum);
            dfs(root.right, sum, targetSum);
            hash.put(sum, hash.get(sum)-1);
        }
    }

    public static void main(String[] args) {
        
    }
}
