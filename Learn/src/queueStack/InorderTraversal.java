/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

package queueStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
	class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

	public static void main(String[] args) {

	}
	
	/**
	 * 递归法：深度优先遍历
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        this.dfs(root, list);
        return list;
    }
	
	private void dfs(TreeNode node, LinkedList<Integer> list) {
		if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
	}
	
	/**
	 * 迭代法：先迭代访问左子树直到最左边的叶子节点，然后将当前节点加入到数组中，然后迭代访问右子树，
	 * 访问方法和之前一样
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal2(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				list.add(cur.val);
				cur = cur.right;
			}
		}
		return list;
	}

}
