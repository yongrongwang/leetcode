/**
 * Given two integer arrays preorder and inorder where preorder is the preorder 
 * traversal of a binary tree and inorder is the inorder traversal of the same 
 * tree, construct and return the binary tree.
 * 
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 
 * Constraints:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */

package binaryTree;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BuildTree2 {
    int p = 0;

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTree2 b = new BuildTree2();
        LevelOrder l = new LevelOrder();
        TreeNode root = b.buildTree(preorder, inorder);
        for (List<Integer> level : l.levelOrder(root)) {
            for (Integer val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
        root = b.buildTree2(preorder, inorder);
        for (List<Integer> level : l.levelOrder(root)) {
            for (Integer val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = inorder.length - 1;
        for (int i = 0; i <= n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, n, map);
    }
    
    /**
     * map保存中序遍历的元素值和对应索引，首先将先序遍历的第一个元素值作为当前节点的值，然后
     * 通过map来获得中序遍历中相同元素值对应索引，将其作为中序遍历左右子树数组的分割点，最后分
     * 别递归遍历左右子树
     * @param preorder
     * @param inStart
     * @param inEnd
     * @param map
     * @return
     */
    private TreeNode build(int[] preorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[p]);
        int mid = map.get(preorder[p]);
        p++;
        node.left = build(preorder, inStart, mid - 1, map);
        node.right = build(preorder, mid + 1, inEnd, map);
        return node;
    }
    
    /**
     * 首先分别用两个指针p1和p2指向中序遍历数组和先序遍历数组的第一个元素，然后从左往右遍历两
     * 个数组，并用p2指向的元素值生成根节点压入栈中。每次压入一个节点就增大p2，弹出一个节点就增
     * 大p1。如果栈顶节点的值和p1指向的元素值不同，就使用p2指向的元素值生成一个节点作为当前栈顶
     * 节点的左孩子，并将新节点压入栈中；否则从栈中弹出尽可能多的节点，直到栈顶节点的值和p1指向
     * 的元素值不同，此时用p2指向的元素值生成一个节点作为最近一次弹出的节点的右孩子
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int n = inorder.length - 1;
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        for (int p2 = 1, p1 = 0; p2 <= n; p2++) {
            if (cur.val == inorder[p1]) {
                for (p1 = p1 + 1; !stack.isEmpty() && stack.peek().val == inorder[p1]; p1++) {
                    cur = stack.pop();
                }
                cur.right = new TreeNode(preorder[p2]);
                cur = cur.right;
            } else {
                stack.push(cur);
                cur.left = new TreeNode(preorder[p2]);
                cur = cur.left;
            }
        }
        return root;
    }
    
}
