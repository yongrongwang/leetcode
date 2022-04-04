/**
 * You are given an integer array nums and an integer target. 
 * You want to build an expression out of nums by adding one of the symbols '+' 
 * and '-' before each integer in nums and then concatenate all the integers.
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
 * and concatenate them to build the expression "+2-1". Return the number of 
 * different expressions that you can build, which evaluates to target.
 * 
 * Example 1:
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * Constraints:
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */

package queueStack;

public class FindTargetSumWays {

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1}; 
		int target = 3;
		FindTargetSumWays f = new FindTargetSumWays();
		System.out.println(f.findTargetSumWays(nums, target) + " " + f.findTargetSumWays2(nums, target));
	}

	public int findTargetSumWays(int[] nums, int target) {
		int n = nums.length;
		int[] sums = new int[n];
		sums[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			sums[i] = sums[i + 1] + nums[i];
		}
        return dfs(sums, nums, target, 0);
    }
	
	/**
	 * 递归法：递归遍历各个元素，每个元素为正值或者负值加到目标值上后作为新的目标值，当所有元素都遍历过
	 * 后且目标值变为0时返回为1否则为0
	 * 优化：sums数组中保存剩下的所有元素的和，如果剩下的所有元素的和小于当前目标值的绝对值，则
	 * 不需要继续
	 * @param sums
	 * @param nums
	 * @param target
	 * @param pos
	 * @return
	 */
	private int dfs(int[] sums, int[] nums, int target, int pos) {
		if (pos == nums.length) {
			return (0 == target ? 1 : 0);
		}
		if (sums[pos] < Math.abs(target)) {
			return 0;
		}
		return dfs(sums, nums, target + nums[pos], pos + 1) + 
				dfs(sums, nums, target - nums[pos], pos + 1);
	}
	
	/**
	 * 迭代法：这个是0-1背包问题，每次决策需要决定是否加上或者减去一个数字，
	 * 二维数组dp[i][j]表示前i个元素累加和为j的方法的个数，可以得到推导式
	 * dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j+nums[i-1]]
	 * 由于目标值的范围为[-sum,sum]，其中sum为所有元素的和，通过加上sum使其范围变为[0,2*sum]
	 * @param nums
	 * @param target
	 * @return
	 */
	public int findTargetSumWays2(int[] nums, int target) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if (target > sum || target < -sum) {
			return 0;
		}
		int[][] dp = new int[nums.length + 1][2 * sum + 1];
		dp[0][0 + sum] = 1;
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 0; j < 2 * sum + 1; j++) {
				if (j - nums[i - 1] >= 0) {
					dp[i][j] += dp[i - 1][j - nums[i - 1]];
				}
				if (j + nums[i - 1] < 2 * sum + 1) {
					dp[i][j] += dp[i - 1][j + nums[i - 1]]; 
				}
			}
		}
		return dp[nums.length][sum + target];
	}
	
}
