/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's 
 * (water), return the number of islands. An island is surrounded by water and is 
 * formed by connecting adjacent lands horizontally or vertically. You may assume 
 * all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * 
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */

package queueStack;

public class NumIslands {
	
	public static void main(String[] args) {
		char[][] grid = {{'1','1','1','1','0'},
				         {'1','1','0','1','0'},
				         {'1','1','0','0','1'},
				         {'0','0','0','1','1'}};
		NumIslands n = new NumIslands();
		int count = n.numIslands(grid);
		System.out.println(count);
	}
	
	/**
	 * 从左往右从上往下遍历数组，当遇到一个为'1'的元素的时候就采用深度优先的搜索方式标记遍历过的元素
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					DFSMark(grid, i, j);
					count++;
				}
			}
		}
        return count;
    }
	
	/**
	 * 采用深度优先的搜索方式遍历数组，每次遇到一个为'1'的元素就将该元素改为'2'来标记已经遍历过的
	 * 元素，然后再依次递归遍历该元素的上下左右四个方向紧挨着的元素
	 * @param grid
	 * @param i
	 * @param j
	 */
	private void DFSMark(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '2';
		DFSMark(grid, i, j - 1);
		DFSMark(grid, i, j + 1);
		DFSMark(grid, i - 1, j);
		DFSMark(grid, i + 1, j);
	}

}
