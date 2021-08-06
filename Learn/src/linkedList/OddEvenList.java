package linkedList;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices
 * together followed by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain
 * as it was in the input. You must solve the problem in O(1) extra space complexity
 * and O(n) time complexity.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [1,3,5,2,4]
 *
 * Constraints:
 * n == number of nodes in the linked list
 * 0 <= n <= 10^4
 * -10^6 <= Node.val <= 10^6
 */
public class OddEvenList {

    public static void main(String[] args) {
        int[] nums = {1};
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        list.visit();
        OddEvenList o = new OddEvenList();
        ListNode h = o.oddEvenList(list.getHead());
        MyLinkedList list2 = new MyLinkedList(h);
        list2.visit();
    }

    /**
     * 使用两个指针，一个用来连接所有的奇数节点，一个用来连接所有的偶数节点，最后拼接奇数节点链表
     * 和偶数节点链表
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode head2 = head.next;
        ListNode odd, even;
        for (odd = head, even = head.next; even != null && even.next != null; odd = odd.next, even = even.next) {
            odd.next = odd.next.next;
            even.next = even.next.next;
        }
        odd.next = head2;
        return head;
    }

}
