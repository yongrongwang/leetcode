/**
 * A peak element is an element that is strictly greater than its neighbors. Given 
 * an integer array nums, find a peak element, and return its index. If the array 
 * contains multiple peaks, return the index to any of the peaks. You may imagine 
 * that nums[-1] = nums[n] = -∞. You must write an algorithm that runs in O(log n) 
 * time.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */

package binarySearch;

public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        FindPeakElement f = new FindPeakElement();
        System.out.println(f.findPeakElement(nums));
    }
    
    /**
     * 由于数组两端是负无穷且没有重复元素，所以局部最大值要么在两端要么在中间某一点，如果中间索引
     * 的元素小于后面一个元素，则搜索右半部分，否则搜索左半部分，直到最终左右边界重合的时候返回
     * 唯一的元素
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
