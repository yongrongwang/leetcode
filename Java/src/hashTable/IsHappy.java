/**
 * Write an algorithm to determine if a number n is happy.
 * - A happy number is a number defined by the following process:
 * - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * - Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * 
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 * Constraints:
 * 1 <= n <= 2^31 - 1
 */

package hashTable;

public class IsHappy {

    public static void main(String[] args) {
        int n = 19;
        IsHappy i = new IsHappy();
        System.out.println(i.isHappy(n));
    }
    
    /**
     * 类似检测是否存在环的问题，使用一快一慢两个指针，慢指针计算一次各位数平方和时快指针计算两
     * 次各位数平方和，当存在环即计算过程中出现了重复的数字，两指针一定会相遇，如果该数字是1则
     * 是开心数字，不是1则不是开心数字
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = digitSum(slow);
            fast = digitSum(digitSum(fast));
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }
    
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

}
