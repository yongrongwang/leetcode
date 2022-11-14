/**
 * Write an efficient algorithm that searches for a value target in an m x n integer
 * matrix matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example 1:
 * Input: matrix = [[ 1, 4, 7,11,15],
 *                  [ 2, 5, 8,12,19],
 *                  [ 3, 6, 9,16,22],
 *                  [10,13,14,17,24],
 *                  [18,21,23,26,30]],
 * target = 5
 * Output: true
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -10^9 <= target <= 10^9
 */

package recursionII;

public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix s = new SearchMatrix();
        int[][] matrix1 = {{-5}};
        int target = -5;
        boolean b = s.searchMatrix(matrix1, target);
        System.out.println(target + ": " + b);
        int[][] matrix = {{ 1, 4, 7,11,15},
                          { 2, 5, 8,12,19},
                          { 3, 6, 9,16,22},
                          {10,13,14,17,24},
                          {18,21,23,26,30}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                target = matrix[i][j];
                b = s.searchMatrix(matrix, target);
                System.out.printf("%2d: " + b + " ",  target);
            }
            System.out.println();
        }
        target = -5;
        b = s.searchMatrix(matrix, target);
        System.out.println(target + ": " + b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    /**
     *   *  * | *  *
     *   *  * | *  *
     *   -----------
     *   *  * | *  *
     *   *  * | *  *
     * 按照行和列的中间分割线将原区域分割成四块，如果目标值小于当前值，则排除右下角区域，递归搜
     * 索其余三个区域，如果目标值大于当前值，则排除左上角区域，递归搜索其余三个区域，如果找到了
     * 目标值返回true。需要注意递归搜索的时候要排除中央元素，包含一半分割线上的元素
     * @param matrix
     * @param target
     * @param top
     * @param bottom
     * @param left
     * @param right
     * @return
     */
    private boolean search(int[][] matrix, int target, int top, int bottom, int left, int right) {
        if (top > bottom || left > right) {
            return false;
        }
        int rMid = (top + bottom) / 2;
        int cMid = (left + right) / 2;
        if (target < matrix[rMid][cMid]) {
            return search(matrix, target, rMid, bottom, left, cMid - 1) ||
                   search(matrix, target, top, rMid - 1, cMid, right) ||
                   search(matrix, target, top, rMid - 1, left, cMid - 1);
        } else if (target > matrix[rMid][cMid]) {
            return search(matrix, target, rMid + 1, bottom, left, cMid) ||
                   search(matrix, target, top, rMid, cMid + 1, right) ||
                   search(matrix, target, rMid + 1, bottom, cMid + 1, right);
        } else {
            return true;
        }
    }

    /**
     * 类比成二叉搜索树，从二维数组的右上角开始搜索，如果目标值小于当前值，则往左搜索，如果目标
     * 值大于当前值，则往下搜索，如果找到了目标值返回true
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;
        while (r <= matrix.length - 1 && c >= 0) {
            if (target < matrix[r][c]) {
                c--;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }

}
