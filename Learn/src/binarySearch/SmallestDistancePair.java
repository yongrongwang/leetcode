/**
 * The distance of a pair of integers a and b is defined as the absolute difference 
 * between a and b. Given an integer array nums and an integer k, return the kth 
 * smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
 * 
 * Example 1:
 * Input: nums = [1,3,1], k = 1
 * Output: 0
 * Explanation: Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * 
 * Constraints:
 * n == nums.length
 * 2 <= n <= 10^4
 * 0 <= nums[i] <= 10^6
 * 1 <= k <= n * (n - 1) / 2
 */

package binarySearch;

import java.util.Arrays;

public class SmallestDistancePair {

    public static void main(String[] args) {
        int[] nums = {62,100,4};
        int k = 2;
        SmallestDistancePair s = new SmallestDistancePair();
        System.out.println(Arrays.toString(nums) + " " + k);
        System.out.println(s.smallestDistancePair(nums, k));
    }
    
    /**
     * 首先对原数组进行排序，然后在0到所有元素最大距离之间进行二分搜索，每次针对一个给定的距离，
     * 统计所有小于等于当前距离的数字对的个数，如果当前个数小于目标值，则搜索右半部分且不包含中间
     * 元素，否则搜索左半部分且包含中间元素
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countPairs(nums, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private int countPairs(int[] nums, int target) {
        int count = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            for (; j < nums.length; j++) {
                if (nums[j] - nums[i] > target) {
                    break;
                }
            }
            count += j - 1 - i;
        }
        return count;
    }

}
