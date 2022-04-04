/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and 
 * n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
 * - [4,5,6,7,0,1,4] if it was rotated 4 times.
 * - [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in 
 * the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]]. Given the sorted rotated array 
 * nums that may contain duplicates, return the minimum element of this array. You 
 * must decrease the overall operation steps as much as possible.
 * 
 * Example 1:
 * Input: nums = [1,3,5]
 * Output: 1
 * 
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums is sorted and rotated between 1 and n times.
 */

package binarySearch;

public class FindMin2 {

    public static void main(String[] args) {
        int[] nums = {3,3,1,3};
        FindMin2 f = new FindMin2();
        System.out.println(f.findMin(nums));
    }
    
    /**
     * 如果中间索引的元素大于右边界的元素，则最小值在右半部分且不包含中间元素，如果中间索引的元
     * 素小于右边界的元素,则最小值在左半部分且包含中间元素，否则将右边界减一来去除重复元素
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
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

}
