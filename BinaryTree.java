import java.util.Stack;

public class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;
    int depth = Integer.MAX_VALUE;
    int lsum = 0;

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    //Find out if a Tree is Balanced.
    //( Tree is balanced if for every node difference between height of left and right is <=1)
    public boolean isBalanced(BinaryTree root) {
        int result;
        result = subTreeBalance(root);

        if (result == -1) {
            System.out.println("The tree is not balanced.");
            return false;
        } else {
            System.out.println("The tree is balanced.");
            return true;
        }
    }

    int subTreeBalance(BinaryTree rootnode) {
        int res = 0;
        int l, r, h = 0;
        if (rootnode == null) {
            return 0;
        }
        l = subTreeBalance(rootnode.left);
        r = subTreeBalance(rootnode.right);
        if (l == -1 || r == -1) {
            return -1;
        }
        res = Math.abs(l - r);
        if (res > 1) {
            return -1;
        }
        return (Math.max(l, r) + 1);
    }

    //Find Minimum depth of all the leaves in a tree.
    public int minDepth(BinaryTree root) {
        int i = 1;
        if (root == null) {
            return 0;
        }
        subTreeDepth(root, i);
        System.out.println("Minimum depth of the tree : " + depth);
        return depth;
    }

    void subTreeDepth(BinaryTree rootnode, int i) {
        if (rootnode == null) {
            return;
        }
        subTreeDepth(rootnode.left, i + 1);
        subTreeDepth(rootnode.right, i + 1);
        if (rootnode.left == null && rootnode.right == null) {
            depth = Math.min(depth, i);
        }
    }

    //Print all the leaves of a tree.
    public void leafNodes(BinaryTree rootNode) {
        BinaryTree tempNode = rootNode;
        Stack<BinaryTree> stack = new Stack<>();
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            if (tempNode.left == null && tempNode.right == null) {
                System.out.print(tempNode.value + ", ");
            }
            tempNode = tempNode.right;
        }
        System.out.println();
    }

    //Print sum of all the left leaves.
    public int sumOfLeftLeaves(BinaryTree root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            System.out.println("Sum of all the left Nodes is : " + lsum);
            return 0;
        }
        subTreeSum(root, false);
        System.out.println("Sum of all the left Nodes is : " + lsum);
        return lsum;
    }

    void subTreeSum(BinaryTree rootnode, boolean flag) {
        if (rootnode == null) {
            return;
        }
        if (rootnode.left == null & rootnode.right == null && flag) {
            lsum += rootnode.value;
        }
        subTreeSum(rootnode.left, true);
        subTreeSum(rootnode.right, false);
    }

    //Main function
    public static void main(String args[]) {
        BinaryTree node7 = new BinaryTree(7, null, null);
        BinaryTree node8 = new BinaryTree(8, node7, null);
        BinaryTree node4 = new BinaryTree(4, node8, null);
//            BinaryTree node6 = new BinaryTree(6,node8,node7);
//            BinaryTree node5 = new BinaryTree(5,node6,null) ;
//            BinaryTree node3 = new BinaryTree(3,null,node5);
        BinaryTree node2 = new BinaryTree(2, node4, null);
        BinaryTree node1 = new BinaryTree(1, node2, null);

        node1.leafNodes(node1);
        node1.isBalanced(node1);
        node1.sumOfLeftLeaves(node1);
        node1.minDepth(node1);
    }
}






