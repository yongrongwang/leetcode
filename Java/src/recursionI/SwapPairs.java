/**
 * Given a linked list, swap every two adjacent nodes and return its head. You
 * must solve the problem without modifying the values in the list's nodes (i.e.,
 * only nodes themselves may be changed.)
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */

package recursionI;
import linkedList.ListNode;
import linkedList.MyLinkedList;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        MyLinkedList list = new MyLinkedList(node1);
        list.visit();
        SwapPairs s = new SwapPairs();
        node1 = s.swapPairs2(node1);
        list = new MyLinkedList(node1);
        list.visit();
    }

    /**
     * 1 -> 2 -> 3 -> 4
     * 递归法：假设head指向节点1，head.next指向节点2，head.next.next指向节点3，head.next.next.next
     * 指向节点4，每次递归先保存节点2，如果节点4存在，则让节点1的next指针指向节点4，否则节点1
     * 的next指针指向节点3，最后让节点2的next指针指向节点1
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next); // 1 -> 4
        next.next = head;  // 2 -> 1
        return next;
    }

    /**
     * dummy -> 1 -> 2 -> 3 -> 4
     * 迭代法：使用虚拟头节点，假设pre指向节点dummy，head指向节点1，head.next指向节点2，
     * head.next.next指向节点3，每次循环先保存节点2，然后让节点1的next指针指向节点3，再让节
     * 点2的next指针指向节点1，最后让pre的next指针指向节点2
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = next.next; // 1 -> 3
            next.next = head;  // 2 -> 1
            pre.next  = next;  // dummy -> 2
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

}
