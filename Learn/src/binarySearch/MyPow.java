/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * 
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * 
 * Constraints:
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 */

package binarySearch;

public class MyPow {

    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        MyPow m = new MyPow();
        System.out.println("x = " + x + " n = " + n + " pow = " + m.myPow(x, n));
    }
    
    /**
     * 使用递归的办法：当为负数的时候先转化为正数，但如果是最小的负数，则为了避免溢出需要特别处理，
     * 都为正数以后，则可以通过x=x*x，n=n/2来减小指数
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : myPow(x * x, n / 2) * x;
    }

}
