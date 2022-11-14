/**
 * Given an integer n, return the least number of perfect square numbers that sum 
 * to n.A perfect square is an integer that is the square of an integer; in other 
 * words, it is the product of some integer with itself. For example, 1, 4, 9, and 
 * 16 are perfect squares while 3 and 11 are not.
 * 
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Constraints:
 * 1 <= n <= 10^4
 */

package queueStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumSquares {

	public static void main(String[] args) {
		int n = 9;
		NumSquares ns = new NumSquares();
		int depth = ns.numSquares(n);
		int depth2 = ns.numSquares2(n);
		System.out.println(depth + " " + depth2);
	}
	
	/**
	 * 先将数字0压入队列，之后每弹出一个数字就将该数字和一个完全平方数相加，如果两数之和不大于
	 * 目标值且没有访问过就将该数字压入队列，直到最后等于目标值则返回查找的深度
	 * @param n
	 * @return
	 */
	public int numSquares(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		queue.offer(0);
		visited.add(0);
		int depth = 1;
		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				int u = queue.poll();
				for (int j = 1; j * j <= n; j++) {
					int v = u + j * j;
					if (v == n) {
						return depth;
					}
					if (v > n) {
						break;
					}
					if (!visited.contains(v)) {
						queue.offer(v);
						visited.add(v);
					}
				}
			}
			depth++;
		}
		
        return depth;
    }
	
	/**
	 * dp[0] = 0 
	 * dp[1] = dp[0]+1 = 1
	 * dp[2] = dp[1]+1 = 2
	 * dp[3] = dp[2]+1 = 3
	 * dp[4] = min{ dp[4-1*1]+1, dp[4-2*2]+1 } = min{ dp[3]+1, dp[0]+1 } = 1
	 * dp[n] = min{ dp[n-i*i]+1 },  n-i*i >= 0 && i >= 1				
	 * @param n
	 * @return
	 */
	public int numSquares2(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}

}
