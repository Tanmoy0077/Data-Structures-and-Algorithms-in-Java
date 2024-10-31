package DSA;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
public class MaxDepthBST {
    public static int solver(TreeNode root){
        if(root == null)
            return 1;
        int left = solver(root.left);
        int right = solver(root.right);
        return Math.max(left, right)+1;
    }
    public static void main(String[] args) {
        
    }
}
