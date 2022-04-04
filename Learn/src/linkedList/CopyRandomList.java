package linkedList;

/**
 * A linked list of length n is given such that each node contains an additional
 * random pointer, which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n
 * brand new nodes, where each new node has its value set to the value of its
 * corresponding original node. Both the next and random pointer of the new nodes
 * should point to new nodes in the copied list such that the pointers in the original
 * list and copied list represent the same list state. None of the pointers in the
 * new list should point to nodes in the original list.
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 * The linked list is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 *  - val: an integer representing Node.val
 *  - random_index: the index of the node (range from 0 to n-1) that the random pointer
 *    points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Constraints:
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random is null or is pointing to some node in the linked list.
 */
public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Integer[][] nums = {{7,null}, {13,0}, {11,4}, {10,2}, {1,0}};
        CopyRandomList c = new CopyRandomList();
        Node head = c.createLinkedList(nums);
        c.printLinkedList(head);
        Node newHead = c.copyRandomList(head);
        c.printLinkedList(newHead);
    }

    private Node createLinkedList(Integer[][] nums) {
        if (nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0][0]);
        Node cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new Node(nums[i][0]);
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][1] != null) {
                Node random = head;
                for (int j = 0; j < nums[i][1]; j++) {
                    random = random.next;
                }
                cur.random = random;
            }
            cur = cur.next;
        }

        return head;
    }

    private void printLinkedList(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + (cur.next == null ? "\n" : " -> "));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.random != null) {
                int i = 0;
                for (Node random = head; random != cur.random; random = random.next) {
                    i++;
                }
                System.out.print(i);
            } else {
                System.out.print("N");
            }
            System.out.print(cur.next != null ? "     " : "\n");
        }
    }

    /**
     * 1.在原来的链表的每个节点后面复制一个相同值的节点
     * 2.通过原来的链表结构构造新的节点的random指针
     * 3.抽取新构造的链表和原来的链表
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
        }
        for (Node cur = head; cur != null && cur.next != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }
        Node newHead = head.next;
        for (Node cur = head; cur != null && cur.next != null; cur = cur.next) {
            Node next = cur.next;
            cur.next = cur.next.next;
            if (next.next != null) {
                next.next = next.next.next;
            }
        }

        return newHead;
    }

}
