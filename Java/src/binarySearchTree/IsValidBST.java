/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */

package binarySearchTree;

import java.util.Stack;

import binaryTree.TreeNode;

public class IsValidBST {
    TreeNode pre = null;
    TreeNode cur = null;

    public static void main(String[] args) {
        /**
         *                5
         *               / \
         *              1   4
         *                 / \
         *                3   6
         */
        TreeNode node1 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(6, null, null);
        TreeNode node3 = new TreeNode(1, null, null);
        TreeNode node4 = new TreeNode(4, node1, node2);
        TreeNode node5 = new TreeNode(5, node3, node4);
        IsValidBST i = new IsValidBST();
        System.out.println(i.isValidBST(node5));
        System.out.println(i.isValidBST2(node5));
    }

    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    /**
     * 递归法：从根节点向左子树递归，则小于当前节点值，向右子树递归，则大于当前节点值。每次遇到
     * 一个节点，如果当前节点小于等于最小值或者大于等于最大值，则返回false
     * @param node
     * @param min
     * @param max
     * @return
     */
    private boolean valid(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min.val) || (max != null && node.val >= max.val)) {
            return false;
        }
        return valid(node.left, min, node) && valid(node.right, node, max);
    }

    /**
     * 迭代法，比较中序遍历时候的相邻的两个节点，如果前一个节点大于等于后一个节点，则返回false
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }

}
