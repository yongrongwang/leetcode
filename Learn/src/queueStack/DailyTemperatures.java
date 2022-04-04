/**
 * Given an array of integers temperatures represents the daily temperatures, return 
 * an array answer such that answer[i] is the number of days you have to wait after 
 * the ith day to get a warmer temperature. If there is no future day for which 
 * this is possible, keep answer[i] == 0 instead.
 * 
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * 
 * Constraints:
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 */

package queueStack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures = {73,74,75,71,69,72,76,73};
		DailyTemperatures d = new DailyTemperatures();
		int[] answer = d.dailyTemperatures(temperatures);
		System.out.println(Arrays.toString(answer));;
	}
	
	/**
	 * 遍历数组中每一个元素，如果当前元素比栈顶数据作为索引的元素要大，则弹出栈顶数据并且求出索引差值，
	 * 然后再将当前元素所在索引压入栈中
	 * @param temperatures
	 * @return
	 */
	public int[] dailyTemperatures(int[] temperatures) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] answer = new int[temperatures.length];
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int index = stack.pop();
				answer[index] = i - index;
			}
			stack.push(i);
		}
		return answer;
    }

}
