/**
 * You are given the root node of a binary search tree (BST) and a value to insert 
 * into the tree. Return the root node of the BST after the insertion. It is guaranteed 
 * that the new value does not exist in the original BST.
 * Notice that there may exist multiple valid ways for the insertion, as long as the 
 * tree remains a BST after insertion. You can return any of them.
 * 
 * Example 1:
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 * Explanation: Another accepted tree is:
 * 
 * Constraints:
 * The number of nodes in the tree will be in the range [0, 10^4].
 * -10^8 <= Node.val <= 10^8
 * All the values Node.val are unique.
 * -10^8 <= val <= 10^8
 * It's guaranteed that val does not exist in the original BST.
 */

package binarySearchTree;

import binaryTree.TreeNode;

public class InsertIntoBST {

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
        BSTIterator b = new BSTIterator(node5);
        while (b.hasNext()) {
            System.out.print(b.next() + " ");
        }
        System.out.println();
        InsertIntoBST i = new InsertIntoBST();
        b = new BSTIterator(i.insertIntoBST(node5, 2));
        while (b.hasNext()) {
            System.out.print(b.next() + " ");
        }
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val > val) {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(val);
                    break;
                }
            } else {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

}
