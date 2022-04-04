package arrayAndString;

import arrays.ArrayUtils;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer,
 * increment one to the integer. The digits are stored such that the most significant
 * digit is at the head of the list, and each element in the array contains a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] nums = {9,9};
        ArrayUtils a = new ArrayUtils();
        a.printArray(nums);
        PlusOne p = new PlusOne();
        nums = p.plusOne(nums);
        a.printArray(nums);
    }

    /**
     * 从右往左扫描数组，如果当前元素加1后小于等于9，则将当前元素加一然后返回数组，否则将当前
     * 元素设置为0，如果扫描结束了依然没有返回数组则说明位溢出，构造一个长度比原数组大1的新数组，
     * 将索引为0的元素设置为1后返回新数组
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] + 1 <= 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;

        return newDigits;
    }

}
