/**
 * Given a root node reference of a BST and a key, delete the node with the given 
 * key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * 1. Search for a node to remove.
 * 2. If the node is found, delete the node.
 * 
 * Example 1:
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 * 
 * Constraints:
 *     The number of nodes in the tree is in the range [0, 10^4].
 *     -10^5 <= Node.val <= 10^5
 *     Each node has a unique value.
 *     root is a valid binary search tree.
 *     -10^5 <= key <= 10^5
 */

package binarySearchTree;

public class DeleteNode {

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
        BSTIterator b = new BSTIterator(node6);
        while (b.hasNext()) {
            System.out.print(b.next() + " ");
        }
        System.out.println();
        DeleteNode d = new DeleteNode();
        b = new BSTIterator(d.deleteNode(node6, 2));
        while (b.hasNext()) {
            System.out.print(b.next() + " ");
        }
    }
    
    /**
     * 如果当前值大于目标值则查找左子树，如果当前值小于目标值则查找右子树，如果当前值等于目标值则：
     * 如果右子树为空则返回左子树，如果左子树为空则返回右子树，如果左右子树都不为空则删除当前节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                delete(root);
            }
        }
        return root;
    }
    
    /**
     * 首先寻找待删除节点的后继节点和后继节点的父节点，然后将后继节点值复制给待删除节点，最后将
     * 后继节点的右子树连接到后继节点的父节点上面
     * @param node
     */
    private void delete(TreeNode node) {
        TreeNode parent = node;
        TreeNode successor = node.right;
        while (successor.left != null) {
            parent = successor;
            successor = successor.left;
        }
        node.val = successor.val;
        if (parent == node) {
            parent.right = successor.right;
        } else {
            parent.left = successor.right;
        }
    }

}
