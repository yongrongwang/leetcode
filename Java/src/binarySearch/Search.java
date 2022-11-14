/**
 * Given an array of integers nums which is sorted in ascending order, and an integer 
 * target, write a function to search target in nums. If target exists, then return 
 * its index. Otherwise, return -1. You must write an algorithm with O(log n) runtime 
 * complexity.
 * 
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * 
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 < nums[i], target < 10^4
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */

package binarySearch;

public class Search {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,12};
        int target = 9;
        Search s = new Search();
        System.out.println(s.search(nums, target));
    }
    
    /**
     * 如果中间索引的值等于目标值，则返回索引，如果大于目标值，则搜索左半部分，如果小于目标值，
     * 则搜索右半部分，如果左边界大于右边界则跳出循环
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
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
