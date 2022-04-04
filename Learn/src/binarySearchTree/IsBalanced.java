/**
 * Given a binary tree, determine if it is height-balanced. For this problem, a 
 * height-balanced binary tree is defined as: a binary tree in which the left and 
 * right subtrees of every node differ in height by no more than 1.
 * 
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -10^4 <= Node.val <= 10^4
 */

package binarySearchTree;
import binaryTree.TreeNode;

public class IsBalanced {

    public static void main(String[] args) {
        /**
         *                4
         *               / 
         *              2   
         *             / \   
         *            1   3   
         */
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(2, node1, node2);
        TreeNode node6 = new TreeNode(4, node4, null);
        IsBalanced i = new IsBalanced();
        System.out.println(i.isBalanced(node6));
    }
    
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }
    
    /**
     * 递归法：如果当前节点为空则返回0，否则依次递归检查左右子树，如果左右子树高度之差小于等于1，
     * 则返回左右子树高度较大者加一，否则返回-1，如果左右子树至少有一边返回-1，则直接返回-1
     * @param node
     * @return
     */
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        if (left != -1) {
            int right = depth(node.right);
            if (right != -1) {
                if (Math.abs(left - right) <= 1) {
                    return Math.max(left, right) + 1;
                }
            }
        }
        return -1;
    }

}
