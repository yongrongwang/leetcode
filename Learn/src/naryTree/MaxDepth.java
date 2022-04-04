/**
 * Given a n-ary tree, find its maximum depth. The maximum depth is the number of 
 * nodes along the longest path from the root node down to the farthest leaf node.
 * Nary-Tree input serialization is represented in their level order traversal, 
 * each group of children is separated by the null value (See examples).
 * 
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * 
 * Constraints:
 * The total number of nodes is in the range [0, 10^4].
 * The depth of the n-ary tree is less than or equal to 1000.
 */

package naryTree;

import java.util.LinkedList;
import java.util.List;

public class MaxDepth {

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
        MaxDepth m = new MaxDepth();
        System.out.println(m.maxDepth(node1));;
    }
    
    /**
     * 自底向上法，递归访问子节点，如果当前节点为空则返回0，否则取所有子树的高度最大者加一作为
     * 返回值
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                depth = Math.max(depth, maxDepth(child));
            }
        }
        return depth + 1;
    }

}
