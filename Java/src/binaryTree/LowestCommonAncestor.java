/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes 
 * in the tree. According to the definition of LCA on Wikipedia: “The lowest common 
 * ancestor is defined between two nodes p and q as the lowest node in T that has 
 * both p and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */

package binaryTree;

public class LowestCommonAncestor {
    TreeNode lca = null;

    public static void main(String[] args) {
        /*
         *            7
         *           / \
         *          5   6
         *         /\   /\
         *        1  2 3  4
         *       /         \
         *      8           9
         */
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node1 = new TreeNode(1, node8, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(4, null, node9);
        TreeNode node5 = new TreeNode(5, node1, node2);
        TreeNode node6 = new TreeNode(6, node3, node4);
        TreeNode node7 = new TreeNode(7, node5, node6);
        LowestCommonAncestor l = new LowestCommonAncestor();
        TreeNode node = l.lowestCommonAncestor(node7, node5, node8);
        System.out.println(node != null ? node.val : "NULL");
    }
    
    /**
     * 如果当前节点等于p或者q，则不再遍历子节点，直接返回当前节点；否则分别递归遍历左子树和右子树。
     * 如果两个子树有一个返回的等于null，则返回另一个的结果，如果两个子树返回的都不等于null，
     * 则返回当前节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (lca != null) {
            return null;
        }
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            lca = root;
            return root;
        }
    }
    
}
