package linkedList;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should
 * be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        list.visit();
        int[] nums1 = {1,3,4};
        MyLinkedList list1 = new MyLinkedList();
        for (int i = 0; i < nums1.length; i++) {
            list1.addAtTail(nums1[i]);
        }
        list1.visit();
        MergeTwoLists m = new MergeTwoLists();
        ListNode h = m.mergeTwoLists2(list.getHead(), list1.getHead());
        MyLinkedList list2 = new MyLinkedList(h);
        list2.visit();
    }

    /**
     * 迭代法：如果两个链表有一个为空则返回不为空的那个链表，否则使用虚拟头节点，让cur指向虚拟
     * 头节点，之后开始遍历两个链表，如果两个链表都没有遍历结束，则对比l1和l2指向的节点的值，将
     * cur.next指向值较小的那个节点，然后相应指针前移一步，如果两个链表有一个遍历结束了，则将
     * cur.next指向剩余的没有遍历完的部分
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            cur.next = (l1.val < l2.val ? l1 : l2);
            if (l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null ? l1 : l2);
        return dummy.next;
    }

    /**
     * 递归法：每次递归，对比l1和l2指向的节点的值，将值较小的那个节点的next指针指向下一次调用
     * 返回的节点，同时将较小的那个链表的指针前移一步，而在下一次调用中，如果有一个链表遍历完了
     * 则直接返回另一个没遍历完的链表，否则同样对比l1和l2指向的节点的值，返回值较小的那个节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}
