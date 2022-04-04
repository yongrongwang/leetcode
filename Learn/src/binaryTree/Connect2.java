/**
 * Given a binary tree
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next 
 * right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.
 * 
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate 
 * each next pointer to point to its next right node, just like in Figure B. The 
 * serialized output is in level order as connected by the next pointers, with '#' 
 * signifying the end of each level.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 */

package binaryTree;

import java.util.List;

public class Connect2 {

    public static void main(String[] args) {
        /*
         *            7
         *           / \
         *          5   6
         *         /\   /\
         *        1  2 3  4
         *       /         \
         *      8           9
         */
        Node node8 = new Node(8, null, null, null);
        Node node9 = new Node(9, null, null, null);
        Node node1 = new Node(1, node8, null, null);
        Node node2 = new Node(2, null, null, null);
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null, node9, null);
        Node node5 = new Node(5, node1, node2, null);
        Node node6 = new Node(6, node3, node4, null);
        Node node7 = new Node(7, node5, node6, null);
        Connect c1 = new Connect();
        Connect2 c2 = new Connect2();
        node7 = c2.connect(node7);
        for (List<Node> level : c1.levelOrder(node7)) {
            for (Node node : level) {
                System.out.print(node.val + "->" + (node.next != null ? node.next.val + " " : "#" + "\n"));
            }
        }
    }
    
    /**
     * 迭代法，一层一层地遍历，head指向当前层的最左边一个节点，cur指向正在遍历节点，pre指向下
     * 一层不为null的节点，当第一次遇到下一层不为null的节点的时候，分别用head和pre指向它，之
     * 后每次遇到下一层不为null的节点的时候，都是先用pre.next指向它，然后pre向前移动一个指针
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        Node head = null;
        Node pre = null;
        while (cur != null) {
            if (cur.left != null) {
                if (pre != null) {
                    pre.next = cur.left;
                } else {
                    head = cur.left;
                }
                pre = cur.left;
            }
            if (cur.right != null) {
                if (pre != null) {
                    pre.next = cur.right;
                } else {
                    head = cur.right;
                }
                pre = cur.right;
            }
            if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = head;
                head = null;
                pre = null;
            }
        }
        return root;
    }
    
    /**
     * 递归法，注意点是要先递归右孩子然后递归左孩子，因为指针连接是左边指向右边，需要先完成右边
     * 再去完成左边，否则在下一层查找下一个非null的节点的时候会出错
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNext(root);
            }
        }
        if (root.right != null) {
            root.right.next = findNext(root);
        }
        connect2(root.right);
        connect2(root.left);
        return root;
    }
    
    /**
     * 在下一层查找下一个非null的节点
     * @param node
     * @return
     */
    private Node findNext(Node node) {
        while (node.next != null) {
            node = node.next;
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
        }
        return null;
    }
    
}
