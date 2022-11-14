/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., 
 * symmetric around its center).
 * 
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 */

package binaryTree;

import java.util.Stack;

public class IsSymmetric {

    public static void main(String[] args) {
        /*
         *            3
         *           / \
         *          2   2
         *           \   \
         *            1   1
         */
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, node1);
        TreeNode node3 = new TreeNode(1, null, null);
        TreeNode node4 = new TreeNode(2, null, node3);
        TreeNode node5 = new TreeNode(3, node2, node4);
        IsSymmetric i = new IsSymmetric();
        System.out.println(i.isSymmetric(node5));
        System.out.println(i.isSymmetric2(node5));
    }
    
    public boolean isSymmetric(TreeNode root) {
        return root == null || validate(root.left, root.right);
    }
    
    private boolean validate(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return validate(left.left, right.right) && validate(left.right, right.left);
    }
    
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

}
