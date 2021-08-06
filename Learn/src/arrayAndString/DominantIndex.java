package arrayAndString;

/**
 * You are given an integer array nums where the largest integer is unique. Determine
 * whether the largest element in the array is at least twice as much as every other
 * number in the array. If it is, return the index of the largest element, or
 * return -1 otherwise.
 *
 * Example 1:
 * Input: nums = [3,6,1,0]
 * Output: 1
 * Explanation: 6 is the largest integer.
 * For every other number in the array x, 6 is at least twice as big as x.
 * The index of value 6 is 1, so we return 1.
 *
 * Constraints:
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * The largest element in nums is unique.
 */
public class DominantIndex {

    public static void main(String[] args) {
        int[] nums = {1};
        DominantIndex d = new DominantIndex();
        int i = d.dominantIndex(nums);
        System.out.println(i);
    }

    /**
     * 先找到数组所有元素中最大值和其索引，然后扫描数组，如果出现元素值的2倍大于最大值且其索引
     * 不等于最大值的索引则返回-1，如果到扫描结束都没有找到这样的元素就返回最大元素的索引
     */
    public int dominantIndex(int[] nums) {
        int maxIndex = -1;
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && 2 * nums[i] > max) {
                return -1;
            }
        }
        return maxIndex;
    }

}
