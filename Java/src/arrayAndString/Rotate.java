package arrayAndString;

import arrays.ArrayUtils;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[count] <= 2^31 - 1
 * 0 <= k <= 10^5
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        ArrayUtils a = new ArrayUtils();
        a.printArray(nums);
        Rotate r = new Rotate();
        r.rotate(nums, k);
        a.printArray(nums);
    }

    /**
     * 1.将索引为0～n-1的元素进行反转
     * 2.将索引为0～k-1的元素进行反转
     * 3.将索引为k～n-1的元素进行反转
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
    }

}
