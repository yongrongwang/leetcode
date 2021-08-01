package arrayAndString;

import utils.ArrayUtils;

/**
 * Given an array of integers nums, calculate the pivot index of this array. The
 * pivot index is the index where the sum of all the numbers strictly to the left
 * of the index is equal to the sum of all the numbers strictly to the index's right.
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left. This also applies to the right edge of the array.
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 * Example 1:
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -1000 <= nums[i] <= 1000
 */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {-1,1,0,1};
        PivotIndex p = new PivotIndex();
        int i = p.pivotIndex(nums);
        System.out.println(i);
    }

    /**
     * 先计算出所有元素之和，然后从左往右扫描数组，每次遇到一个新元素就将该元素左侧元素之和与
     * 右侧元素之和进行对比，如果相等就返回当前索引，之后再将该元素值加到左侧元素之和
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

}
