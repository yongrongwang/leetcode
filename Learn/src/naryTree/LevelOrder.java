/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, 
 * each group of children is separated by the null value (See examples).
 * 
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * 
 * Constraints:
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */

package naryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    
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
        LevelOrder l = new LevelOrder();
        List<List<Integer>> list = l.levelOrder(node1);
        for (List<Integer> level : list) {
            for (Integer item : level) {
                System.out.print(item + " ");
            }
        }
    }
    
    /**
     * 先将根节点压入队列，之后每弹出一个节点，先将该节点的值添加到保存该层节点的数组中，然后将
     * 该节点的所有子节点加入到队列，遍历完一层节点就将保存该层节点的数组添加到保存所有节点的数
     * 组中，队列为空时返回保存所有节点的数组
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<Integer>();
            for (int i = queue.size(); i > 0; i--) {
                Node cur = queue.poll();
                level.add(cur.val);
                if (cur.children != null) {
                    for (Node child : cur.children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }
    
}
