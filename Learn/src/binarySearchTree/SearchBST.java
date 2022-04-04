/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree 
 * rooted with that node. If such a node does not exist, return null.
 * 
 * Example 1:
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 10^7
 * root is a binary search tree.
 * 1 <= val <= 10^7
 */

package binarySearchTree;

public class SearchBST {

    public static void main(String[] args) {
        /**
         *                4
         *               / \
         *              3   5
         *             /     \
         *            1       6
         */
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(6, null, null);
        TreeNode node3 = new TreeNode(3, node1, null);
        TreeNode node4 = new TreeNode(5, null, node2);
        TreeNode node5 = new TreeNode(4, node3, node4);
        SearchBST s = new SearchBST();
        node5 = s.searchBST(node5, 2);
        if (node5 != null) {
            System.out.println("True");
            BSTIterator b = new BSTIterator(node5);
            while (b.hasNext()) {
                System.out.print(b.next() + " ");
            }
        } else {
            System.out.println("False");
        }
    }
    
    /**
     * 如果当前值等于目标值则返回当前节点，如果当前值大于目标值则查找左子树，否则查找右子树
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

}
