/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting 
 * and ending position of a given target value. If target is not found in the array, 
 * return [-1, -1]. You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 */

package binarySearch;

import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        SearchRange s = new SearchRange();
        System.out.println(Arrays.toString(s.searchRange(nums, target)));
    }
    
    /**
     * 分别找到第一次和最后一次出现目标值的索引
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] index = {-1, -1};
        if (nums.length == 0) {
            return index;
        }
        index[0] = findFirst(nums, target);
        index[1] = findLast(nums, target);
        return index;
    }
    
    /**
     * 要找到第一次出现目标值的索引，如果中间索引的元素大于等于目标值，则目标值在左半部分且包含
     * 中间元素，如果中间索引的元素小于目标值，则目标值在右半部分且不包含中间元素，最后左右边界
     * 重合的位置即为第一次出现目标值的索引
     * @param nums
     * @param target
     * @return
     */
    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
    
    /**
     * 要找到最后一次出现目标值的索引，如果中间索引的元素小于等于目标值，则目标值在右半部分且包含
     * 中间元素，如果中间索引的元素大于目标值，则目标值在左半部分且不包含中间元素，最后左右边界
     * 重合的位置即为最后一次出现目标值的索引
     * @param nums
     * @param target
     * @return
     */
    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

}
