/**
 * You are given a perfect binary tree where all leaves are on the same level, 
 * and every parent has two children. The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next 
 * right node, the next pointer should be set to NULL. Initially, all next pointers 
 * are set to NULL.
 * 
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should 
 * populate each next pointer to point to its next right node, just like in Figure 
 * B. The serialized output is in level order as connected by the next pointers, 
 * with '#' signifying the end of each level.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 212 - 1].
 * -1000 <= Node.val <= 1000
 */

package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Connect {

    public static void main(String[] args) {
        /*
         *            7
         *           / \
         *          5   6
         *         /\   /\
         *        1  2 3  4
         */
        Node node1 = new Node(1, null, null, null);
        Node node2 = new Node(2, null, null, null);
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, node1, node2, null);
        Node node6 = new Node(6, node3, node4, null);
        Node node7 = new Node(7, node5, node6, null);
        Connect c = new Connect();
        node7 = c.connect(node7);
        for (List<Node> level : c.levelOrder(node7)) {
            for (Node node : level) {
                System.out.print(node.val + "->" + (node.next != null ? node.next.val + " " : "#" + "\n"));
            }
        }
    }
    
    /**
     * 迭代法，一层一层地遍历，head指向当前层的最左边一个节点，cur指向正在遍历节点，对于遍历到
     * 的每一个有孩子的节点，将它的左孩子指向右孩子，右孩子指向下一个节点的左孩子
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        Node head = root;
        while (cur != null && cur.left != null) {
            cur.left.next = cur.right;
            if (cur.next != null) {
                cur.right.next = cur.next.left;
                cur = cur.next;
            } else {
                head = head.left;
                cur = head;
            }
        }
        return root;
    }
    
    /**
     * 递归法，充分利用next指针，对于每一个有孩子的节点，将它的左孩子指向右孩子，右孩子指向下一
     * 个节点的左孩子，最后递归遍历左孩子和右孩子
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;
        root.right.next = (root.next != null ? root.next.left : null);
        connect2(root.left);
        connect2(root.right);
        return root;
    }
    
    public List<List<Node>> levelOrder(Node root) {
        List<List<Node>> list = new LinkedList<List<Node>>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Node> level = new LinkedList<Node>();
            for (int i = queue.size(); i > 0; i--) {
                Node cur = queue.poll();
                level.add(cur);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(level);
        }
        return list;
    }

}
