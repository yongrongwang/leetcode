/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: 
 * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely 
 * and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each 
 * move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 
 * wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of 
 * these codes, the wheels of the lock will stop turning and you will be unable 
 * to open it.
 * Given a target representing the value of the wheels that will unlock the lock, 
 * return the minimum total number of turns required to open the lock, or -1 if 
 * it is impossible.
 * 
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> 
 * "1201" -> "1202" -> "0202". Note that a sequence like "0000" -> "0001" -> 
 * "0002" -> "0102" -> "0202" would be invalid, because the wheels of the lock 
 * become stuck after the display becomes the dead end "0102".
 * 
 * Constraints:
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target will not be in the list deadends.
 * target and deadends[i] consist of digits only.
 */

package queueStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

	public static void main(String[] args) {
		String[] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		OpenLock o = new OpenLock();
		int steps = o.openLock(deadends, target);
		System.out.println(steps);
	}
	
	/**
	 * 先将字符串"0000"压入队列，之后每弹出一个字符串就将该字符串的4个字符对应的数字做递增或者
	 * 递减操作，如果操作后的字符串不在deadends数组中且没有访问过就将该字符串压入队列，直到最后
	 * 等于目标字符串则返回查找的深度
	 * @param deadends
	 * @param target
	 * @return
	 */
	public int openLock(String[] deadends, String target) {
		Set<String> deads = new HashSet<String>(Arrays.asList(deadends));
		if (deads.contains("0000")) {
			return -1;
		}
		Queue<String> queue = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		queue.offer("0000");
		visited.add("0000");
		int depth = 0;
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				String str = queue.poll();
				if (str.equals(target)) {
					return depth;
				}
				StringBuilder builder = new StringBuilder(str);
				for (int j = 0; j < str.length(); j++) {
					char c = builder.charAt(j);
					String str1 = builder.substring(0, j) + (c == '9' ? 0 : c - '0' + 1) 
							+ builder.substring(j + 1);
					String str2 = builder.substring(0, j) + (c == '0' ? 9 : c - '0' - 1) 
							+ builder.substring(j + 1);
					if (!deads.contains(str1) && !visited.contains(str1)) {
						queue.offer(str1);
						visited.add(str1);
					}
					if (!deads.contains(str2) && !visited.contains(str2)) {
						queue.offer(str2);
						visited.add(str2);
					}
				}
			}
			depth++;
		}
        return -1;
    }

}
