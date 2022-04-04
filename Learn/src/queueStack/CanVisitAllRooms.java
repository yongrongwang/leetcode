/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except 
 * for room 0. Your goal is to visit all the rooms. However, you cannot enter a 
 * locked room without having its key. When you visit a room, you may find a set 
 * of distinct keys in it. Each key has a number on it, denoting which room it 
 * unlocks, and you can take all of them with you to unlock the other rooms. Given 
 * an array rooms where rooms[i] is the set of keys that you can obtain if you visited 
 * room i, return true if you can visit all the rooms, or false otherwise.
 * 
 * Example 1:
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation: 
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 * 
 * Constraints:
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * All the values of rooms[i] are unique.
 */

package queueStack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CanVisitAllRooms {

    public static void main(String[] args) {
        int[][] arr = {{7,16,8,19},{10},{9,11},{3,14,16,19},{8,10,19,1,7},{13,5,10,15,4},{6,13},{14,11,12,18},{3},{17,9},{1,2,6,9},{12,2},{4},{2,13,17},{17},{},{11,15},{3,5},{15,18,5},{7,18,1}};
        List<List<Integer>> rooms = new LinkedList<List<Integer>>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = new LinkedList<Integer>();
            for (int j = 0; j < arr[i].length; j++) {
                list.add(arr[i][j]);
            }
            rooms.add(list);
        }
        System.out.println(rooms);
        CanVisitAllRooms c = new CanVisitAllRooms();
        System.out.println(c.canVisitAllRooms(rooms));
    }
    
    /**
     * DFS：将房间号0压入堆栈中，每次从堆栈中弹出一个元素作为钥匙拿到对应的房间中所有的钥匙，如果
     * 该钥匙对应的房间没有被访问过，则将其压入堆栈，最后判断访问过的房间总数是否等于所有的房间数
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        visited.add(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int index = stack.pop();
            for (int key : rooms.get(index)) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    stack.push(key);
                }
                if (visited.size() == rooms.size()) {
                    return true;
                }
            }
        }
        return visited.size() == rooms.size();
    }

}
