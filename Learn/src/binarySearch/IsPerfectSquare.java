/**
 * Given a positive integer num, write a function which returns True if num is a 
 * perfect square else False. Follow up: Do not use any built-in library function 
 * such as sqrt.
 * 
 * Example 1:
 * Input: num = 16
 * Output: true
 * 
 * Constraints:
 * 1 <= num <= 2^31 - 1
 */

package binarySearch;

public class IsPerfectSquare {

    public static void main(String[] args) {
        IsPerfectSquare is = new IsPerfectSquare();
        for (int i = 1; i <= 1000; i++) {
            boolean sqr = is.isPerfectSquare(i);
            System.out.println("num = " + i + " isPerfectSquare ? " + sqr);
        }
    }
    
    /**
     * 如果中间数字的平方等于目标值，则返回该数字，如果中间数字的平方大于目标值，则搜索左半部分，
     * 否则搜索右半部分
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
