/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two 
 * given nodes in the BST. According to the definition of LCA on Wikipedia: “The 
 * lowest common ancestor is defined between two nodes p and q as the lowest node 
 * in T that has both p and q as descendants (where we allow a node to be a descendant 
 * of itself).”
 * 
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [2, 10^5].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 */

package binarySearchTree;

import binaryTree.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        /**
         *                4
         *               / \
         *              2   5
         *             / \   \
         *            1   3   6
         */
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(3, null, null);
        TreeNode node3 = new TreeNode(6, null, null);
        TreeNode node4 = new TreeNode(2, node1, node2);
        TreeNode node5 = new TreeNode(5, null, node3);
        TreeNode node6 = new TreeNode(4, node4, node5);
        LowestCommonAncestor l = new LowestCommonAncestor();
        TreeNode node = l.lowestCommonAncestor(node6, node5, node3);
        System.out.println(node != null ? node.val : "NULL");
    }
    
    /**
     * 如果当前节点的值大于p的值和q的值则查找左子树，如果当前节点的值小于p的值和q的值则查找右子
     * 树，当前节点的值在p的值和q的值之间则返回当前节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

}
