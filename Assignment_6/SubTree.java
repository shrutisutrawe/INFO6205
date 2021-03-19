
package INFO6205.Assignment_6;

public class SubTree {
    public static boolean subTree = false;

    public static boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        isSubTreeRecursion(s, t);
        return subTree;
    }

    private static boolean isSubTreeRecursion(TreeNode s, TreeNode t) {
        if (s != null) {
            subTree = (subTreeExists(s, t) || isSubTreeRecursion(s.left, t) || isSubTreeRecursion(s.right, t));
        }
        return subTree;
    }

    private static boolean subTreeExists(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && subTreeExists(s.left, t.left) && subTreeExists(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode nodeS0 = new TreeNode(0, null, null);
        TreeNode nodeS2 = new TreeNode(2, nodeS0, null);
        TreeNode nodeS1 = new TreeNode(1, null, null);
        TreeNode nodeS4 = new TreeNode(4, nodeS1, nodeS2);
        TreeNode nodeS5 = new TreeNode(5, null, null);
        TreeNode nodeS3 = new TreeNode(3, nodeS4, nodeS5);
        TreeNode nodeT2 = new TreeNode(2, null, null);
        TreeNode nodeT1 = new TreeNode(1, null, null);
        TreeNode nodeT4 = new TreeNode(4, nodeT1, nodeT2);
        System.out.println(isSubTree(nodeS3, nodeT4));


    }
}
