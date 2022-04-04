/**
 * Given the head of a singly linked list, reverse the list, and return the reversed
 * list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */

package linkedList;

public class ReverseList {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        list.visit();
        ReverseList r = new ReverseList();
        ListNode h = r.reverseList2(list.getHead());
        MyLinkedList list2 = new MyLinkedList(h);
        list2.visit();
    }

    /**
     * 迭代法：使用两个相邻指针，一个指向head，一个指向head前一个节点prev，每次循环先保存head
     * 后一个节点next，然后反转head的next指针指向preｖ，最后prev和head同时向前走一步．
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 递归法：每次递归先反转head.next的next指针指向head，然后让head的next指针指向null，
     * 最后返回最后一个节点作为最新的头节点
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

}
