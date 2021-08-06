package linkedList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * You are given a doubly linked list which in addition to the next and previous
 * pointers, it could have a child pointer, which may or may not point to a separate
 * doubly linked list. These child lists may have one or more children of their own,
 * and so on, to produce a multilevel data structure, as shown in the example below.
 * Flatten the list so that all the nodes appear in a single-level, doubly linked
 * list. You are given the head of the first level of the list.
 *
 * Example 1:
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 * The input multilevel linked list is as follows:
 * 1---2---NULL
 * |
 * 3---NULL
 *
 * Constraints:
 * The number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */
public class Flatten {
    class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * How multilevel linked list is represented in test case:
     * 1---2---3---4---5---6--NULL
     *         |
     *         7---8---9---10--NULL
     *             |
     *             11--12--NULL
     *
     * [1,2,3,4,5,6,null]
     * [null,null,7,8,9,10,null]
     * [null,11,12,null]
     *
     * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
     */
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12};
        Flatten f = new Flatten();
        System.out.println("Before flattened: ");
        f.printLinkedList(nums);
        System.out.println("After flattened: ");
        for (Node cur = f.flatten(f.createLinkedList(nums)); cur != null; cur = cur.next) {
            System.out.print(cur.val + (cur.next == null ? "\n" : " <-> "));
        }
    }

    private void printLinkedList(Integer[] nums) {
        int i = 0;
        int t = 0;
        while (i < nums.length) {
            if (nums[i] == null) {
                System.out.println(" N");
                while (t > 0) {
                    System.out.print("      ");
                    t--;
                }
                while (nums[++i] == null) {
                    System.out.print(" N -- ");
                    t++;
                }
            } else {
                System.out.printf("%2d", nums[i]);
                System.out.print(" -- ");
                i++;
            }
        }
        System.out.println(" N");
    }

    private Node createLinkedList(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0]);
        Node cur = head;
        Node t = cur;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != null) {
                if (i == nums.length - 1 || nums[i + 1] == null) {
                    cur.next = null;
                } else {
                    cur.next = new Node(nums[i + 1]);
                }
                cur.child = null;
                cur = cur.next;
                i++;
            } else {
                while (nums[++i] == null) {
                    t = t.next;
                }
                Node node = new Node(nums[i]);
                t.child = node;
                cur = node;
                t = node;
            }
        }
        return head;
    }

    /**
     * 依次遍历每一个节点
     * 1.如果当前节点没有子节点，继续前进；
     * 2.如果当前节点有子节点，找到子节点所在层的尾节点，然后将尾节点和当前节点下一个节点连接，
     * 再将当前节点和子节点连接
     */
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        for (Node cur = head; cur != null; ) {
            if (cur.child == null) {
                cur = cur.next;
                continue;
            }
            Node tail = cur.child;
            for (; tail.next != null; tail = tail.next) {}
            tail.next = cur.next;
            if (cur.next != null) {
                cur.next.prev = tail;
            }
            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;
        }
        return head;
    }

}
