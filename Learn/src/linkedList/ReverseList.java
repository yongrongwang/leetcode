package linkedList;

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
public class ReverseList {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        list.visit();
        ReverseList r = new ReverseList();
        ListNode h = r.reverseList(list.getHead());
        MyLinkedList list2 = new MyLinkedList(h);
        list2.visit();
    }

    /**
     * 使用两个相邻指针，一个指向head，一个指向head前一个节点prev，每次循环先保存head后一个节点
     * next，然后反转head的next指针指向preｖ，最后prev和head同时向前走一步．
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

}
