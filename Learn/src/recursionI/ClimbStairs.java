/**
 * You are climbing a staircase. It takes n steps to reach the top. Each time you
 * can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Constraints:
 * 1 <= n <= 45
 */

package recursionI;

public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        for (int i = 1; i < 6; i++) {
            System.out.println(c.climbStairs(i));
        }
    }

    /**
     * n = 1, fn = 1, |         |       | 1     |
     * n = 2, fn = 2, | 1+1     | 2     |       |
     * n = 3, fn = 3, | 1+1+1   | 2+1   | 1+2   |
     * 这是一个斐波那契数列问题，起始值为1和2，理由是：为了爬上n级台阶，可以由两种方法达到，一
     * 种是从n-1级台阶向上爬一级，一种是从n-2级台阶向上爬两级，且这两种方法是爬上n级台阶的必要
     * 且充分条件，因为这两种方法既包含了达到n级台阶的所有情况，而且它们之间没有重叠
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        while (n > 2) {
            int sum = f1 + f2;
            f1 = f2;
            f2 = sum;
            n--;
        }
        return f2;
    }

}
