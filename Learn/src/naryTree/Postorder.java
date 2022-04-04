/**
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' 
 * values. Nary-Tree input serialization is represented in their level order traversal. 
 * Each group of children is separated by the null value (See examples)
* 
* Example 1:
* Input: root = [1,null,3,2,4,null,5,6]
* Output: [5,6,3,2,4,1]
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

public class Postorder {
    
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
        Postorder p = new Postorder();
        List<Integer> list = p.postorder2(node1);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<Integer>();
        postorder(root, list);
        return list;
    }
    
    /**
     * 递归法，先迭代访问子树直到叶子节点，处理子节点按照从左往右的顺序，然后将当前节点加入到数
     * 组中
     * @param root
     * @param list
     */
    private void postorder(Node root, List<Integer> list) {
        if (root != null) {
            if (root.children != null) {
                for (Node node : root.children) {
                    postorder(node, list);
                }
            }
            list.add(root.val);
        }
    }
    
    /**
     * 迭代法，将节点和该节点已访问的子节点的个数包装成一个类，先将根结点和0压入堆栈，之后每次
     * 将栈顶节点作为当前节点，如果当前节点不是叶子节点且还有子节点没有访问过，则将子节点和0压入
     * 堆栈，并且将当前节点的已访问的子节点的个数值加一；如果当前节点是叶子节点或者所有子节点已
     * 经访问过了，则将当前节点加入到结果数组中，并且弹出当前节点
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        class Pair {
            Node node;
            int index;
            public Pair(Node node, int index) {
                this.node = node;
                this.index = index;
            }
        }
        List<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<Pair> stack = new Stack<Pair>();
        Pair cur = null;
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            cur = stack.peek();
            List<Node> children = cur.node.children;
            if (children != null && cur.index != children.size()) {
                stack.push(new Pair(children.get(cur.index), 0));
                cur.index++;
            } else {
                list.add(cur.node.val);
                stack.pop();
            }
        }
        return list;
    }
    
}
