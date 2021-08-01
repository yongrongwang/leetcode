package arrayAndString;

import utils.ArrayUtils;

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in
 * a diagonal order.
 *
 * Example 1:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * -10^5 <= mat[i][j] <= 10^5
 */
public class FindDiagonalOrder {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayUtils a = new ArrayUtils();
        a.print2dArray(mat);
        FindDiagonalOrder f = new FindDiagonalOrder();
        int[] nums = f.findDiagonalOrder(mat);
        a.printArray(nums);
    }

    /**
     * [0][0] [0][1] [1][0] [2][0] [1]1] [0][2] [1][2] [2][1] [2][2]
     * 行索引和列索引加起来是偶数的时候向斜上方滑动，是奇数的时候向斜下方滑动，
     * 向斜上方滑动的时候，如果列索引到达了右边界，则向下滑动，如果行索引等于0，则向右滑动，
     * 向斜下方滑动的时候，如果行索引到达了下边界，则向右滑动，如果列索引等于0，则向下滑动
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] nums = new int[m * n];
        int i = 0;
        int j = 0;

        for (int p = 0; p < nums.length; p++) {
            nums[p] = mat[i][j];
            if ((i + j) % 2 == 0) {
                if (j == n - 1) {
                    i++;
                } else if (i == 0) {
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
        }

        return nums;
    }

}
