package DSA;

public class LowestCommonAncestor {
    public static TreeNode lca(TreeNode root, TreeNode left, TreeNode right){
        if(root == null)
            return null;
        TreeNode leftVal = lca(root.left, left, right);
        TreeNode rightVal = lca(root.right, left, right);

        if(root == left)
            leftVal = root;
        if(root == right)
            rightVal = root;

        if(leftVal != null && rightVal != null)
            return root;
        if(leftVal != null)
            return leftVal;
        if(rightVal != null)
            return rightVal;
        return null;
    }
    public static void solver(TreeNode root, TreeNode p, TreeNode q){
        TreeNode result = lca(root, p, q);
        System.out.println("The lowest common ancestor is : "+result.val);
    }
    public static void main(String[] args) {
        
    }
}
