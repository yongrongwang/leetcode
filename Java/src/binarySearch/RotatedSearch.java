/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown 
 * pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], 
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
 * example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. 
 * Given the array nums after the possible rotation and an integer target, return 
 * the index of target if it is in nums, or -1 if it is not in nums. You must write 
 * an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Constraints:
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 */

package binarySearch;

import java.util.Arrays;

public class RotatedSearch {
    int i = 0;

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(Arrays.toString(nums));
        RotatedSearch r = new RotatedSearch();
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            System.out.println("num = " + target + "  index = " + " " + r.search(nums, target));
        }

    }
    
    /**
     * 如果中间索引的数字等于目标值，则返回该索引，否则
     * 1. 如果左半部分有序且目标值在左半部分，则搜索左半部分；如果左半部分有序且目标值不在左半部分，
     * 则搜索右半部分
     * 2. 如果右半部分有序且目标值在右半部分，则搜索右半部分；如果右半部分有序且目标值不在右半部分，
     * 则搜索左半部分
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    
}
