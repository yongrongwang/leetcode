/**
 * Implement the BSTIterator class that represents an iterator over the in-order 
 * traversal of a binary search tree (BST):
 * - BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. 
 *   The root of the BST is given as part of the constructor. The pointer should be 
 *   initialized to a non-existent number smaller than any element in the BST.
 * - boolean hasNext() Returns true if there exists a number in the traversal to 
 *   the right of the pointer, otherwise returns false.
 * - int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the 
 * first call to next() will return the smallest element in the BST.
 * You may assume that next() calls will always be valid. That is, there will be 
 * at least a next number in the in-order traversal when next() is called.
 * 
 * Example 1:
 * Input
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", 
 * "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, 3, 7, true, 9, true, 15, true, 20, false] 
 * Explanation
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // return 3
 * bSTIterator.next();    // return 7
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 9
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 15
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 20
 * bSTIterator.hasNext(); // return False
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^5].
 * 0 <= Node.val <= 10^6
 * At most 10^5 calls will be made to hasNext, and next.
 */

package binarySearchTree;

import java.util.Stack;
import binaryTree.TreeNode;

public class BSTIterator {
    private Stack<TreeNode> stack = null;
    private TreeNode node = null;

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
    }
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        node = root;
    }
    
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int val = node.val;
        node = node.right;
        return val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }

}
