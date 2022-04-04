/**
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
 * Now in every subsequent row, we look at the previous row and replace each occurrence
 * of 0 with 01, and each occurrence of 1 with 10. For example, for n = 3, the 1st
 * row is 0, the 2nd row is 01, and the 3rd row is 0110. Given two integer n and k,
 * return the kth (1-indexed) symbol in the nth row of a table of n rows.
 *
 * Example 1:
 * Input: n = 1, k = 1
 * Output: 0
 * Explanation: row 1: 0
 *
 * Constraints:
 * 1 <= n <= 30
 * 1 <= k <= 2^n - 1
 */

package recursionI;

public class KthGrammar {

    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {
            int length = (int) Math.pow(2, i - 1);
            KthGrammar kth = new KthGrammar();
            for (int j = 1; j <= length; j++) {
                System.out.print(kth.kthGrammar(i, j) + " ");
            }
            System.out.println();
        }
    }

    /**
     *     0
     *    / \
     *   0   1
     *  / \ / \
     * 0  1 1  0
     * 递归法：所有的0和1组合起来可以看成一个二叉树，如果当前节点是0，则它的两个左右子节点分别
     * 是0和1，如果当前节点是1，则它的两个左右子节点分别是1和0。如果子节点是当前行的第k个节点，
     * 则父节点是上一行的第(k+1)/2个节点，通过在树上递归来不断向上查找父节点直到根结点，然后
     * 再由父节点一层层判断得到子节点值
     * @param n
     * @param k
     * @return
     */
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int result = kthGrammar(n - 1, (k + 1) / 2);
        int bit = k & 1;
        return result ^ (1 - bit);
    }

    /**
     * 迭代法：看成一个二叉树，假设子节点是当前行的第k个节点，
     * 1. 如果k是奇数，此时为父节点的左孩子，和父节点相同 => f(k)=f((k+1)/2)^0
     * 2. 如果k是偶数，此时为父节点的右孩子，和父节点不同 => f(k)=f((k+1)/2)^1
     * 从第k个节点到第1个节点异或0或者1总共k-1次，假设索引从0开始，则k为奇数的时候和1异或，k
     * 为偶数的时候和0异或，也就是k的二进制表示的各位数字之间进行异或，举例：
     * k=7，k-1=6=110，f(111)=f(11)^0=f(1)^1^0=f(0)^1^1^0=1^1^0=0
     * 容易得到如果k的二进制表示的1的个数为偶数则为0，1的个数为奇数则为1
     * @param n
     * @param k
     * @return
     */
    public int kthGrammar2(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }

}
