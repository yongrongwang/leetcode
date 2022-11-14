package arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements. Note that you must do this in-place
 * without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroes m = new MoveZeroes();
        ArrayUtils a = new ArrayUtils();
        a.printArray(nums);
        m.moveZeroes(nums);
        a.printArray(nums);
    }

    /**
     * 从左往右扫描数组，每当遇到一个非0值就将其写入最左侧未被写过的位置，最后将余下的位置填充为0
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

}
