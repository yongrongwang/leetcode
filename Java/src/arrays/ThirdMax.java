package arrays;

/**
 * Given integer array nums, return the third maximum number in this array. If the
 * third maximum does not exist, return the maximum number.
 *
 * Example 1:
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation: The third maximum is 1.
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 */
public class ThirdMax {

    public static void main(String[] args) {
        int[] nums = {3,-2,-2,-1};
        ThirdMax t = new ThirdMax();
        int m = t.thirdMax(nums);
        System.out.println(m);
    }

    /**
     * 从左往右扫描，找到该次扫描的最大值，保存第一次扫描的最大值作为备用，再做一次从左往右
     * 扫描，每当遇到该次扫描的最大值就和最后一个元素互换，然后数组长度减一，像这样找最大值找三次
     */
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int length = nums.length;
        int number = 0;

        while (length > 0 && number < 3) {
            max = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            if (number == 0) {
                max1 = max;
            }
            for (int i = 0; i < length; i++) {
                if (nums[i] == max) {
                    for (int j = length - 1; j >= i; j--) {
                        length--;
                        if (nums[j] != max) {
                            nums[i] = nums[j];
                            break;
                        }
                    }
                }
            }
            number++;
        }

        return number < 3 ? max1 : max;
    }

}
