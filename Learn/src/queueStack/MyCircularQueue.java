/**
 * Design your implementation of the circular data. The circular queue is a linear 
 * data structure in which the operations are performed based on FIFO (First In 
 * First Out) principle and the last position is connected back to the first position 
 * to make a circle. It is also called "Ring Buffer".
 * One of the benefits of the circular queue is that we can make use of the spaces 
 * in front of the data. In a normal queue, once the queue becomes full, we cannot 
 * insert the next element even if there is a space in front of the data. But using 
 * the circular queue, we can use the space to store new values.
 * Implementation the MyCircularQueue class:
 *  - MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 *  - int Front() Gets the front item from the data. If the queue is empty, return -1.
 *  - int Rear() Gets the last item from the data. If the queue is empty, return -1.
 *  - boolean enQueue(int value) Inserts an element into the circular data. Return 
 *  - true if the operation is successful.
 *  - boolean deQueue() Deletes an element from the circular data. Return true if 
 *  - the operation is successful.
 *  - boolean isEmpty() Checks whether the circular queue is empty or not.
 *  - boolean isFull() Checks whether the circular queue is full or not.
 *  You must solve the problem without using the built-in queue data structure in 
 *  your programming language.
 *  
 *  Example 1:
 *  Input
 *  ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", 
 *  "deQueue", "enQueue", "Rear"]
 *  [[3], [1], [2], [3], [4], [], [], [], [4], []]
 *  Output
 *  [null, true, true, true, false, 3, true, true, true, 4]
 *  Explanation
 *  MyCircularQueue myCircularQueue = new MyCircularQueue(3);
 *  myCircularQueue.enQueue(1); // return True
 *  myCircularQueue.enQueue(2); // return True
 *  myCircularQueue.enQueue(3); // return True
 *  myCircularQueue.enQueue(4); // return False
 *  myCircularQueue.Rear();     // return 3
 *  myCircularQueue.isFull();   // return True
 *  myCircularQueue.deQueue();  // return True
 *  myCircularQueue.enQueue(4); // return True
 *  myCircularQueue.Rear();     // return 4
 *  
 *  Constraints:
 *  1 <= k <= 1000
 *  0 <= value <= 1000
 *  At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.
 */

package queueStack;

public class MyCircularQueue {
	
	private int front;
	private int rear;
	private int size;
	private int[] data;

	public static void main(String[] args) {
		int k = 3;
		MyCircularQueue obj = new MyCircularQueue(k);
		System.out.println(obj.enQueue(1));
		System.out.println(obj.enQueue(2));
		System.out.println(obj.enQueue(3));
		System.out.println(obj.enQueue(4));
		System.out.println(obj.Front());
		System.out.println(obj.Rear());
		System.out.println(obj.isFull());
		System.out.println(obj.isEmpty());
		System.out.println(obj.deQueue());
		System.out.println(obj.enQueue(4));
		System.out.println(obj.Front());
		System.out.println(obj.Rear());
	}

	public MyCircularQueue(int k) {
		front = 0;
		rear = -1;
		size = 0;
        data = new int[k];
    }
    
    public boolean enQueue(int value) {
    	if (isFull()) {
    		return false;
    	}
    	rear = (rear + 1) % data.length;
        data[rear] = value;
        ++size;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
			return false;
		}
        front = (front + 1) % data.length;
        --size;
        return true;
    }
    
    public int Front() {
    	if (isEmpty()) {
			return -1;
		}
        return data[front];
    }
    
    public int Rear() {
    	if (isEmpty()) {
			return -1;
		}
        return data[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == data.length;
    }
	
}
