package linkedList;

/**
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {
        int[] nums = {3,2,0,4};
        int n = 3;
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        list.visit();
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode h = r.removeNthFromEnd(list.getHead(), n);
        MyLinkedList list2 = new MyLinkedList(h);
        list2.visit();
    }

    /**
     * 使用两个指针p和q，p先出发，q后出发，先出发的比后出发的早走n步．如果p在走n步之后为null，
     * 则删掉头节点并返回；否则两指针每次走一步，当p为尾节点的时候，删掉q后面一个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n && p != null; i++) {
            p = p.next;
        }
        if (p == null) {
            return head.next;
        }
        while (p != null && p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }

}
