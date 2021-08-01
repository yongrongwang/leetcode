package arrayAndString;

import utils.ArrayUtils;

/**
 * Given an array of integers numbers that is already sorted in non-decreasing
 * order, find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers (1-indexed) as an integer array answer
 * of size 2, where 1 <= answer[0] < answer[1] <= numbers.length. The tests are
 * generated such that there is exactly one solution. You may not use the same
 * element twice.
 *
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * Constraints:
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {-1,0};
        ArrayUtils a = new ArrayUtils();
        a.printArray(nums);
        TwoSum t = new TwoSum();
        int target = -1;
        int[] r = t.twoSum(nums, target);
        a.printArray(r);
    }

    /**
     * 两指针分别从两边往中间扫描，如果两指针指向的元素之和等于要求的target，则分别对索引加1后
     * 返回，如果大于要求的target，则右指针向左移动一个位置，如果小于要求的target，则左指针向
     * 右移动一个位置
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i + 1, j + 1};
    }

}
