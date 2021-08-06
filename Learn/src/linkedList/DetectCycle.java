package linkedList;

/**
 * Given a linked list, return the node where the cycle begins. If there is no 
 * cycle, return null. There is a cycle in a linked list if there is some node in 
 * the list that can be reached again by continuously following the next pointer. 
 * Internally, pos is used to denote the index of the node that tail's next pointer 
 * is connected to. Note that pos is not passed as a parameter. 
 * Notice that you should not modify the linked list. 
 * 
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the 
 * second node.
 * 
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104]. 
 * -10^5 <= Node.val <= 10^5 
 * pos is -1 or a valid index in the linked-list.
 */
public class DetectCycle {

    public static void main(String[] args) {
        int[] nums = {3,2,0,4};
        int pos = 1;
        HasCycle h = new HasCycle();
        MyLinkedList obj = h.createCycle(nums, pos);
        DetectCycle d = new DetectCycle();
        System.out.println(d.detectCycle(obj.getHead()).val);;
    }
    
    /*
     * 使用一快一慢两个指针同时从链表起点出发，快指针一次两步，慢指针一次一步，当两指针相遇的时候，再用
     * 一个慢指针从链表起点开始一次一步地走，同时原来的慢指针继续往前走，两指针相遇的结点就是环起点
     * 假设从链表起点到环起点距离为x，从环起点到相遇点距离y，从相遇点到环起点距离为z，环一圈长度为r， 则 
     * 2(x+y+M*r)=x+y+N*r => x+y=(N-2M)r，又由于y+z=r，令K=N-2M，所以x+(r-z)=Kr，x=z+(K-1)r
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow1 = head;
                while (slow != slow1) {
                    slow = slow.next;
                    slow1 = slow1.next;
                }
                return slow;
            }
        }
        return null;
    }

}
