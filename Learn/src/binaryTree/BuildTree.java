/**
 * Given two integer arrays inorder and postorder where inorder is the inorder 
 * traversal of a binary tree and postorder is the postorder traversal of the same 
 * tree, construct and return the binary tree.
 * 
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * 
 * Constraints:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */

package binaryTree;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BuildTree {
    int p = 0;

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        BuildTree b = new BuildTree();
        LevelOrder l = new LevelOrder();
        TreeNode root = b.buildTree(inorder, postorder);
        for (List<Integer> level : l.levelOrder(root)) {
            for (Integer val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
        root = b.buildTree2(inorder, postorder);
        for (List<Integer> level : l.levelOrder(root)) {
            for (Integer val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = inorder.length - 1;
        for (int i = 0; i <= n; i++) {
            map.put(inorder[i], i);
        }
        p = n;
        return build(postorder, 0, n, map);
    }
    
    /**
     * map保存中序遍历的元素值和对应索引，首先将后序遍历的最后一个元素值作为当前节点的值，然后
     * 通过map来获得中序遍历中相同元素值对应索引，将其作为中序遍历左右子树数组的分割点，最后分
     * 别递归遍历左右子树
     * @param postorder
     * @param inStart
     * @param inEnd
     * @param map
     * @return
     */
    private TreeNode build(int[] postorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[p]);
        int mid = map.get(postorder[p]);
        p--;
        node.right = build(postorder, mid + 1, inEnd, map);
        node.left = build(postorder, inStart, mid - 1, map);
        return node;
    }
    
    /**
     * 首先分别用两个指针p1和p2指向中序遍历数组和后序遍历数组的最后一个元素，然后从右往左遍历两
     * 个数组，并用p2指向的元素值生成一个节点作为当前节点。每次压入一个节点就减小p2，弹出一个节
     * 点就减小p1。如果当前节点的值和p1指向的元素值不同，就使用p2指向的元素值生成一个节点作为当
     * 前栈顶节点的右孩子，并将新节点压入栈中；否则从栈中弹出尽可能多的节点，直到栈顶节点的值和向
     * p1指的元素值不同，此时用p2指向的元素值生成一个节点作为最近一次弹出的节点的左孩子
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int n = inorder.length - 1;
        TreeNode root = new TreeNode(postorder[n]);
        TreeNode cur = root;
        for (int p2 = n - 1, p1 = n; p2 >= 0; p2--) {
            if (cur.val == inorder[p1]) {
                for (p1 = p1 - 1; !stack.isEmpty() && stack.peek().val == inorder[p1]; p1--) {
                    cur = stack.pop();
                }
                cur.left = new TreeNode(postorder[p2]);
                cur = cur.left;
            } else {
                stack.push(cur);
                cur.right = new TreeNode(postorder[p2]);
                cur = cur.right;
            }
        }
        return root;
    }

}
