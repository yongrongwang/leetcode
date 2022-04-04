/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' 
 * values. Nary-Tree input serialization is represented in their level order traversal. 
 * Each group of children is separated by the null value (See examples)
 * 
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 10^4].
 * 0 <= Node.val <= 10^4
 * The height of the n-ary tree is less than or equal to 1000.
 */

package naryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Preorder {

    public static void main(String[] args) {
        /*
         *             1
         *           / | \
         *          2  3  4
         *         / \
         *        5   6
         */
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> list1 = new LinkedList<Node>();
        list1.add(node5);
        list1.add(node6);
        Node node2 = new Node(2, list1);
        List<Node> list2 = new LinkedList<Node>();
        list2.add(node2);
        list2.add(node3);
        list2.add(node4);
        Node node1 = new Node(1, list2);
        Preorder p = new Preorder();
        List<Integer> list = p.preorder2(node1);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<Integer>();
        preorder(root, list);
        return list;
    }
    
    /**
     * 递归法，先将当前节点加入到数组中，然后迭代访问子树直到叶子节点，处理子节点按照从左往右的
     * 顺序
     * @param root
     * @param list
     */
    private void preorder(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for (Node node : root.children) {
                    preorder(node, list);
                }
            }
        }
    }
    
    /**
     * 迭代法，先将根结点压入堆栈，之后每次从堆栈中弹出一个节点，先将该节点加入到数组中，然后将
     * 该节点的子节点按照从右往左的顺序压入堆栈
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<Node>();
        Node cur = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            list.add(cur.val);
            List<Node> children = cur.children;
            if (children != null) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return list;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
