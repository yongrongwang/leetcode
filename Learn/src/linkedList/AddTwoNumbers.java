package linkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single
 * digit. Add the two numbers and return the sum as a linked list. You may assume
 * the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        int[] nums = {9,9,9,9,9,9,9};
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        list.visit();
        int[] nums2 = {9,9,9,9};
        MyLinkedList list2 = new MyLinkedList();
        for (int i = 0; i < nums2.length; i++) {
            list2.addAtTail(nums2[i]);
        }
        list2.visit();
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode head = a.addTwoNumbers(list.getHead(), list2.getHead());
        MyLinkedList list3 = new MyLinkedList(head);
        list3.visit();
    }

    /**
     * 使用虚拟头节点来将头节点的插入和其它节点的插入统一化，每次从两个链表中各取一个节点，将它们
     * 的数值进行相加并加上进位作为sum，用sum % 10的结果作为val创建一个新的节点并插入新的链表，
     * 再用sum / 10的结果作为下一次循环的进位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (sum != 0 || l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        return dummy.next;
    }

}
