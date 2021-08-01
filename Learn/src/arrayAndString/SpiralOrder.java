package arrayAndString;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        ArrayUtils a = new ArrayUtils();
        a.print2dArray(mat);
        SpiralOrder s = new SpiralOrder();
        List<Integer> nums = s.spiralOrder(mat);
        System.out.println(nums);
    }

    /**
     * [0][0] [0][1] [0][2] [1][2] [2][2] [2][1] [2][0] [1][0] [1][1]
     * 先行不变从左往右滑动且结束后增大起始行，然后列不变从上往下滑动且结束后减小末尾列，再行不
     * 变从右往左滑动且结束后减小末尾行，最后列不变从下往上滑动且结束后增大起始列，需要注意为了
     * 防止重复，在向左滑动时候需要检测起始行小于等于末尾行，在向上滑动时候需要检测起始列小于等
     * 于末尾列
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> nums = new ArrayList<Integer>();
        int rowBegin = 0;
        int rowEnd = m - 1;
        int colBegin = 0;
        int colEnd = n - 1;

        while (nums.size() < m * n) {
            for (int j = colBegin; j <= colEnd; j++) {
                nums.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                nums.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    nums.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    nums.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }

        return nums;
    }

}
