package linkedList;

/**
 * Design your implementation of the linked list. You can choose to use a singly
 * or doubly linked list. A node in a singly linked list should have two attributes:
 * val and next. val is the value of the current node, and next is a pointer/reference
 * to the next node. If you want to use the doubly linked list, you will need one
 * more attribute prev to indicate the previous node in the linked list. Assume
 * all nodes in the linked list are 0-indexed.
 * Implement the MyLinkedList class:
 *   - MyLinkedList() Initializes the MyLinkedList object.
 *   - int get(int index) Get the value of the indexth node in the linked list. If
 *     the index is invalid, return -1.
 *   - void addAtHead(int val) Add a node of value val before the first element of
 *     the linked list. After the insertion, the new node will be the first node of
 *     the linked list.
 *   - void addAtTail(int val) Append a node of value val as the last element of the
 *     linked list.
 *   - void addAtIndex(int index, int val) Add a node of value val before the indexth
 *     node in the linked list. If index equals the length of the linked list, the
 *     node will be appended to the end of the linked list. If index is greater than
 *     the length, the node will not be inserted.
 *   - void deleteAtIndex(int index) Delete the indexth node in the linked list,
 *     if the index is valid.
 *
 * Example 1:
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 *
 * Constraints:
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and
 * deleteAtIndex.
 */
public class MyLinkedList {
    private int size;
    private ListNode head;

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.visit();
        list.addAtHead(2);
        list.visit();
        list.addAtHead(1);
        list.visit();
        list.addAtIndex(3,0);
        list.visit();
        list.deleteAtIndex(2);
        list.visit();
        list.addAtHead(6);
        list.visit();
        /*obj.addAtTail(3);
        obj.visit();
        obj.addAtIndex(1,2);
        obj.visit();*/
        /*obj.deleteAtIndex(0);
        obj.visit();*/
        /*int i = 1;
        System.out.println("index = " + i + ", val = " + obj.get(i));*/
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public MyLinkedList(ListNode head) {
        this.head = head;
        this.size = this.getSize();
    }

    public ListNode getHead() {
        return head;
    }

    public int getSize() {
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    /** Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1. */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        return getNode(index).val;
    }

    public ListNode getNode(int index) {
        if (index >= size) {
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /** Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        addAtTail(node);
    }

    public void addAtTail(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode cur = head;
            for (; cur.next != null; cur = cur.next) {}
            cur.next = node;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If
     * index equals to the length of linked list, the node will be appended to the
     * end of linked list. If index is greater than the length, the node will not
     * be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            ListNode node = new ListNode(val);
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        size--;
    }


    public void visit() {
        if (head == null) {
            return;
        }
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val + (cur.next == null ? "\n" : " -> "));
        }
    }
}
