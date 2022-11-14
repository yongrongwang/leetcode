/**
 * Given a non-negative integer x, compute and return the square root of x. Since 
 * the return type is an integer, the decimal digits are truncated, and only the 
 * integer part of the result is returned. Note: You are not allowed to use any 
 * built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 * 
 * Example 1:
 * Input: x = 4
 * Output: 2
 * 
 * Constraints:
 * 0 <= x <= 2^31 - 1
 */

package binarySearch;

public class MySqrt {

    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        int max = 2147395599;
        for (int i = 0; i * i < max; i++) {
            System.out.println(i * i + " " + m.mySqrt(i * i));
        }
    }

    /**
     * 如果中间数字的平方小于等于目标值且中间数字加一后的平方大于目标值，则返回该数字，如果中间
     * 数字的平方大于目标值，则搜索左半部分，否则搜索右半部分
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}
