package linkedList;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at
 * which the two lists intersect. If the two linked lists have no intersection at
 * all, return null. For example, the following two linked lists begin to intersect
 * at node c1: The test cases are generated such that there are no cycles anywhere
 * in the entire linked structure. Note that the linked lists must retain their
 * original structure after the function returns.
 * Custom Judge:
 * The inputs to the judge are given as follows (your program is not given these
 * inputs):
 * intersectVal - The value of the node where the intersection occurs. This is 0
 * if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to
 * get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to
 * get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass
 * the two heads, headA and headB to your program. If you correctly return the
 * intersected node, then your solution will be accepted.
 *
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2,
 * skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if
 * the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as
 * [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3
 * nodes before the intersected node in B.
 *
 * Constraints:
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 0 <= m, n <= 3 * 10^4
 * 1 <= Node.val <= 10^5
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        int intersectVal = 5;
        int[] listA = {4,1,8,4,5};
        int[] listB = {5,6,1,8,4,5};
        int skipA = 4;
        int skipB = 5;
        GetIntersectionNode g = new GetIntersectionNode();
        MyLinkedList[] lists = g.createIntersection(listA, listB, intersectVal, skipA, skipB);
        ListNode node = g.getIntersectionNode(lists[0].getHead(), lists[1].getHead());
        System.out.println("Value of intersection node: " + node.val);
    }

    public MyLinkedList[] createIntersection(int[] listA, int[] listB, int intersectVal,
                                   int skipA, int skipB) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < listA.length; i++) {
            list.addAtTail(listA[i]);
        }
        MyLinkedList list1 = new MyLinkedList();
        for (int i = 0; i < skipB; i++) {
            list1.addAtTail(listB[i]);
        }
        ListNode interNode = list.getNode(skipA);
        list1.addAtTail(interNode);
        if (intersectVal == 0) {
            list.visit();
            list1.visit();
        } else {
            visitIntersection(list.getHead(), list1.getHead(), interNode, skipA, skipB);
        }
        return new MyLinkedList[] {list, list1};
    }
    public void visitIntersection(ListNode headA, ListNode headB, ListNode interNode,
                                  int skipA, int skipB) {
        ListNode curA = headA;
        ListNode curB = headB;
        if (skipA < skipB) {
            for (int i = 0; i < skipB - skipA; i++) {
                System.out.print("     ");
            }
        }
        for (; curA != interNode; curA = curA.next) {
            System.out.print(curA.val + (curA.next == interNode ? "\n" : " -> "));
        }
        if (skipA < skipB) {
            for (int i = 0; i < skipB - skipA; i++) {
                System.out.print("     ");
            }
        }
        for (curA = headA; curA.next != interNode; curA = curA.next) {
            System.out.print("     ");
        }
        System.out.println(" \\");
        ListNode cur;
        if (skipA > skipB) {
            cur = headA;
        } else {
            cur = headB;
        }
        for (; cur.next != interNode; cur = cur.next) {
            System.out.print("     ");
        }
        System.out.print("  -> ");
        for (cur = cur.next; cur.next != null; cur = cur.next) {
            System.out.print(cur.val + " -> ");
        }
        System.out.println(cur.val);
        if (skipA > skipB) {
            for (int i = 0; i < skipA - skipB; i++) {
                System.out.print("     ");
            }
        }
        for (; curB.next != interNode; curB = curB.next) {
            System.out.print("     ");
        }
        System.out.println(" /");
        if (skipA > skipB) {
            for (int i = 0; i < skipA - skipB; i++) {
                System.out.print("     ");
            }
        }
        for (curB = headB; curB != interNode; curB = curB.next) {
            System.out.print(curB.val + (curB.next == interNode ? "\n" : " -> "));
        }
    }

    /**
     * 使用两个指针分别从两个链表起点同时出发，一次走一步，如果第一遍遍历结束之前就相遇，则返回相遇
     * 的节点;否则当走到链表终点的时候，则将其重置到另一个链表起点，继续一次走一步，如果第二遍遍历结束
     * 之前相遇，则返回相遇的节点，否则返回null．
     * 假设A的长度为l1，B的长度为l2，从A的起点到交点长度为a，从交点到终点长度为c，从B的起点到交点
     * 长度为b，则第一遍遍历的时候指针curA走了l1=a+c，curB走了l2=b+c，第二遍遍历的时候指针curA
     * 走了l1+b=a+c+b，curB走了l2+a=b+c+a，由于a+b=b+c，所以在走了a+c+b步之后两指针必然会在
     * 交点相遇，如果没有相遇则没有交点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = (curA == null ? headB : curA.next);
            curB = (curB == null ? headA : curB.next);
        }
        return curA;
    }

}
