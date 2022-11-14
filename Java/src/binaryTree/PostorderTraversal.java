/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * 
 * Constraints:
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public static void main(String[] args) {
        /*
         *            5
         *           / \
         *          2   4
         *         /   /
         *        1   3
         */
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(4, node3, null);
        TreeNode node5 = new TreeNode(5, node2, node4);
        PostorderTraversal p = new PostorderTraversal();
        for (Integer val : p.postorderTraversal(node5)) {
            System.out.print(val + " ");
        }
        System.out.println();
        for (Integer val : p.postorderTraversal2(node5)) {
            System.out.print(val + " ");
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        dfs(root, list);
        return list;
    }
    
    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
        list.add(node.val);
    }

    /**
     * 迭代法：先迭代访问左子树直到最左边的叶子节点，然后迭代访问右子树，访问方法和之前一样，最
     * 后将当前节点加入到数组中。当访问的当前节点是叶子节点或者左右节点都已经访问过后才可以加入
     * 当前节点到数组中
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek().right;
                if (cur == null || cur == pre) {
                    pre = stack.pop();
                    list.add(pre.val);
                    cur = null;
                }
            }
        }
        return list;
    }

}
