/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and 
 * n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * - [4,5,6,7,0,1,2] if it was rotated 4 times.
 * - [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
 * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]]. Given the sorted rotated 
 * array nums of unique elements, return the minimum element of this array. You 
 * must write an algorithm that runs in O(log n) time.
 * 
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 */

package binarySearch;

public class FindMin {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        FindMin f = new FindMin();
        System.out.println(f.findMin(nums));
    }
    
    /**
     * 如果中间索引的元素大于右边界的元素，则最小值在右半部分且不包含中间元素，否则最小值在左半
     * 部分且包含中间元素
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
