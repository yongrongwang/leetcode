/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each 
 * cell. The distance between two adjacent cells is 1.
 * 
 * Example 1:
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * 
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */

package queueStack;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        UpdateMatrix um = new UpdateMatrix();
        QueueStackUtil u = new QueueStackUtil();
        u.printMat(mat);
//        u.printMat(um.updateMatrix(mat));
        u.printMat(um.updateMatrix2(mat));
    }
    
    /**
     * BFS：使用队列来保证处理的顺序是从0出发由近及远进行处理。先将所有为0的元素的索引压入队列，
     * 并且把所有的非0元素设置为-1来打上标记，之后每次弹出一个元素的索引就按照上下左右四个方向
     * 分别进行处理，如果该方向的索引合法且元素未被访问过，则将当前元素值设置为弹出来的索引所在的
     * 元素值加一，然后将当前索引压入队列
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int[] dir = {0, 1, 0, -1, 0};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1; 
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int r0 = top[0];
            int c0 = top[1];
            for (int i = 0; i < dir.length - 1; i++) {
                int r1 = r0 + dir[i];
                int c1 = c0 + dir[i + 1];
                if (r1 >= 0 && r1 < m && c1 >= 0 && c1 < n && mat[r1][c1] == -1) {
                    mat[r1][c1] = mat[r0][c0] + 1;
                    queue.offer(new int[]{r1, c1});
                }
            }
        }
        return mat;
    }
    
    /**
     * BP：需要重复利用之前计算过的值。分为两个大步骤对非0元素进行处理：
     * 1. 从左上角往右下角进行处理，每遇到一个新元素，就通过取它的上边或者左边相邻元素值中较小值
     * 并加一来得到当前元素值
     * 2. 从右下角往左上角进行处理，每遇到一个新元素，就通过取它的下边或者右边相邻元素值中较小值
     * 并加一后再与第一步得到的结果进行比较，取较小值作为当前元素值
     * @param mat
     * @return
     */
    public int[][] updateMatrix2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int max = m + n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    int top = (i - 1 >= 0 ? mat[i - 1][j] : max);
                    int left = (j - 1 >= 0 ? mat[i][j - 1] : max);
                    mat[i][j] = Math.min(top, left) + 1; 
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int bottom = (i + 1 <= m - 1 ? mat[i + 1][j] : max);
                    int right = (j + 1 <= n - 1 ? mat[i][j + 1] : max);
                    mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
                }
            }
        }
        return mat;
    }
    
}
