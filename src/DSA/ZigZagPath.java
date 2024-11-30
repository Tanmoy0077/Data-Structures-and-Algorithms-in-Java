package DSA;

public class ZigZagPath {
    // ! Time limit exceeded
    /*
    public static int check(TreeNode root, char dir, int count){
        if(root == null)
            return count-1;
        if(dir == 'l'){
            count = check(root.left, 'r', count+1);
        }
        else{
            count = check(root.right, 'l', count+1);
        }
        return count;
    }
    public static int find_zigzag(TreeNode root, int count){
        if(root != null){
            int leftLength = check(root.left, 'r', 1);
            int rightLength = check(root.right, 'l', 1);
            count = Math.max(count, Math.max(leftLength, rightLength));
            count = find_zigzag(root.left, count);
            count = find_zigzag(root.right, count);
        }
        return count;
    }
    public static void solver(TreeNode root){
        int count = find_zigzag(root, 0);
        System.out.println("Max ZigZag length: "+count);
    }
     */

    // * Accepted solution
    private static int maxLength;

    private static int maxZigZag(TreeNode root, char direction){
        if(root == null)
            return 0;
        int tc, nc;
        if(direction == 'r'){
            tc = maxZigZag(root.right, 'l');
            nc = maxZigZag(root.left, 'r');
        }
        else{
            tc = maxZigZag(root.left, 'r');
            nc = maxZigZag(root.right, 'l');
        }
        maxLength = Math.max(maxLength, tc);
        maxLength = Math.max(maxLength, nc);
        return tc+1;
    }

    public static void solver(TreeNode root){
        int tc, nc;
        maxLength = 0;
        tc = maxZigZag(root.right, 'l');
        nc = maxZigZag(root.left, 'r');
        maxLength = Math.max(maxLength, tc);
        maxLength = Math.max(maxLength, nc);
        System.out.println(maxLength);
    }
     public static void main(String[] args) {
        
    }
}
