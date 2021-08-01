package arrays;

import utils.ArrayUtils;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val
 * in nums in-place. The relative order of the elements may be changed.Since it
 * is impossible to change the length of the array in some languages, you must
 * instead have the result be placed in the first part of the array nums. More
 * formally, if there are k elements after removing the duplicates, then the first
 * k elements of nums should hold the final result. It does not matter what you
 * leave beyond the first k elements.Return k after placing the final result in
 * the first k slots of nums. Do not allocate extra space for another array. You
 * must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of
 * nums being 2. It does not matter what you leave beyond the returned k (hence
 * they are underscores).
 *
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3};
        int val = 3;
        RemoveElement r = new RemoveElement();
        ArrayUtils a = new ArrayUtils();
        a.printArray(nums);
        int k = r.removeElement(nums, val);
        a.printArray(nums, k);
    }

    /**
     * 从左往右扫描数组，将每次遇到的不等于val的元素放到数组的合适位置
     */
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[length++] = nums[i];
            }
        }

        return length;
    }

}
