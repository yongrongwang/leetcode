package linkedList;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 500].
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 */
public class RotateRight {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;
        System.out.println("k = " + k);
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        list.visit();
        RotateRight r = new RotateRight();
        ListNode head = r.rotateRight(list.getHead(), k);
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + (cur.next == null ? "\n" : " -> "));
        }
    }

    /**
     *
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 1;
        ListNode cur = head;
        for (; cur.next != null; cur = cur.next) {
            size++;
        }
        cur.next = head;
        for (int i = 0; i < size - k % size; i++) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }

}
