package arrayAndString;

/**
 * Given an array of positive integers nums and a positive integer target, return
 * the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 * of which the sum is greater than or equal to target. If there is no such subarray,
 * return 0 instead.
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Constraints:
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        MinSubArrayLen m = new MinSubArrayLen();
        int s = m.minSubArrayLen(target, nums);
        System.out.println(s);
    }

    /**
     * 使用两个指针表示一个窗口，移动右边指针来获得一个合法的窗口，找到合法的窗口以后，移动
     * 左边指针来获得一个更小的窗口
     */
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int length = nums.length + 1;
        int sum = 0;

        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= target) {
                sum -= nums[i++];
                length = Math.min(length, j - i + 1);
            }
        }

        return i == 0 ? 0 : length;
    }

}
