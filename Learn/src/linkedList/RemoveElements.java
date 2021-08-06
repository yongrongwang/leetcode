package linkedList;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the
 * linked list that has Node.val == val, and return the new head.
 *
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class RemoveElements {

    public static void main(String[] args) {
        int[] nums = {1,1,2,6,3,4,5,6};
        int val = 1;
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        list.visit();
        RemoveElements r = new RemoveElements();
        ListNode h = r.removeElements(list.getHead(), val);
        MyLinkedList list2 = new MyLinkedList(h);
        list2.visit();
    }

    /**
     * 先处理除了头节点以外的所有节点，使用一个指针遍历所有节点，如果当前节点数值等于val则删除
     * 当前节点，否则跳过当前节点，最后如果头节点数值等于val则删除头节点。
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        for (ListNode cur = head; cur != null && cur.next != null; ) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head.val == val ? head.next : head;
    }

}
