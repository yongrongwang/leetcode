package linkedList;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle
 * in it. There is a cycle in a linked list if there is some node in the list that
 * can be reached again by continuously following the next pointer. Internally,
 * pos is used to denote the index of the node that node1's next pointer is connected
 * to. Note that pos is not passed as a parameter. Return true if there is a cycle
 * in the linked list. Otherwise, return false.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the node1 connects to
 * the 1st node (0-indexed).
 *
 * Constraints:
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 */
public class HasCycle {

    public static void main(String[] args) {
        int[] nums = {3,2,0,-4};
        int pos = 0;
        HasCycle h = new HasCycle();
        MyLinkedList obj = h.createCycle(nums, pos);
        System.out.println("Has cycle ? " + h.hasCycle(obj.getHead()));
    }

    public MyLinkedList createCycle(int[] nums, int pos) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        ListNode node1 = list.getHead();
        if (node1 == null || pos < 0 || pos >= nums.length - 1) {
            return list;
        }
        for (; node1.next != null; node1 = node1.next) {}
        int size = list.getSize();
        ListNode node2 = list.getHead();
        for (int i = 0; i < nums.length; i++) {
            if (i == pos) {
                node1.next = node2;
                break;
            }
            node2 = node2.next;
        }
        visitCycle(list, node1, node2, size);
        return list;
    }

    public void visitCycle(MyLinkedList list, ListNode from, ListNode to, int size) {
        ListNode cur = list.getHead();
        for (int i = 0; i < size; i++) {
            System.out.print(cur.val + (i == size - 1 ? "\n" : " -> "));
            cur = cur.next;
        }
        cur = list.getHead();
        int p = -1;
        int q = -1;
        for (int i = 0; i < size; i++) {
            if (cur == to) {
                q = i;
            }
            if (cur == from) {
                p = i;
            }
            cur = cur.next;
        }
        if (p == -1 || q == -1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (i == p || i == q) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
            if (i == size - 1) {
                System.out.println();
            } else {
                System.out.print("    ");
            }
        }
        for (int i = 0; i < size; i++) {
            if (i >= q && i < p) {
                System.out.print("  <- ");
            } else {
                System.out.print(" ");
            }
            if (i == size - 1) {
                System.out.println();
            } else if (i < q) {
                System.out.print("    ");
            }
        }
    }

    /**
     * 使用一个快指针和一个慢指针同时遍历链表，如果快指针和慢指针相遇了，则说明有环路，否则没有环路
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

}
