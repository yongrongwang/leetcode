package arrayAndString;

import java.util.Arrays;

/**
 * Given an integer array nums of 2n integers, group these integers into n pairs
 * (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i
 * is maximized. Return the maximized sum.
 *
 * Example 1:
 * Input: nums = [1,4,3,2]
 * Output: 4
 * Explanation: All possible pairings (ignoring the ordering of elements) are:
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * So the maximum possible sum is 4.
 *
 * Constraints:
 * 1 <= n <= 10^4
 * nums.length == 2 * n
 * -10^4 <= nums[i] <= 10^4
 */
public class ArrayPairSum {

    public static void main(String[] args) {
        int[] nums = {6,-2,6,-5,1,2};
        ArrayPairSum p = new ArrayPairSum();
        int s = p.arrayPairSum(nums);
        System.out.println(s);
    }

    /**
     * 因为两两配对取其小者进行求和，要使这个和最大，就需要配对的两个差值最小，先对数组进行排序，
     * 然后取索引为偶数的元素进行求和就得到最大和
     */
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

}
