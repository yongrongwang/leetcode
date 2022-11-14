/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci
 * sequence, such that each number is the sum of the two preceding ones, starting
 * from 0 and 1. That is,
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Constraints:
 * 0 <= n <= 30
 */

package recursionI;

public class Fib {

    public static void main(String[] args) {
        Fib f = new Fib();
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ": " + f.fib(i));
        }
    }

    /**
     * 迭代法：使用两个变量f0和f1存储中间计算的数值，先将f0和f1存储为0和1，然后不断向前迭代计算
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        while (n > 1) {
            int sum = f0 + f1;
            f0 = f1;
            f1 = sum;
            n--;
        }
        return f1;
    }

    /**
     * 递归法：使用数组缓存中间计算的数值，如果当前要计算的数值在数组中存在则直接取出，否则缓存
     * 要计算的数值到数组中
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        return calculte(n, new int[n - 1]);
    }

    private int calculte(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }
        if (cache[n - 2] == 0) {
            cache[n - 2] = calculte(n - 1, cache) + calculte(n - 2, cache);
        }
        return cache[n - 2];
    }

}
