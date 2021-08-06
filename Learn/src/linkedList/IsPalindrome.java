package linkedList;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Constraints:
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 */
public class IsPalindrome {

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,1};
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < nums.length; i++) {
            list.addAtTail(nums[i]);
        }
        list.visit();
        IsPalindrome i = new IsPalindrome();
        System.out.println("Is palindrome ? " + i.isPalindrome(list.getHead()));;
    }

    /**
     * 1.使用一快一慢两个指针同时从链表起点出发，快指针一次两步，慢指针一次一步，当快指针到达终
     * 点的时候，慢指针刚好到达中点，如果是奇数个节点，则慢指针继续往前走一步；
     * 2.从慢指针指向的位置开始反转链表，使用两个指针分别指向原来的链表头节点和新生成的链表头节
     * 点，然后挨个比较节点，如果出现不相等的节点数值则返回false，如果所有节点数值都相等则返回true
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        for (; fast != null && fast.next != null; fast = fast.next.next, slow = slow.next) {}
        if (fast != null) {
            slow = slow.next;
        }
        for (ListNode right = reverseList(slow), left = head; left != null && right != null; left = left.next, right = right.next) {
            if (left.val != right.val) {
                return false;
            }
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
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
