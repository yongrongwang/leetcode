/**
 * An image is represented by an m x n integer grid image where image[i][j] represents 
 * the pixel value of the image. You are also given three integers sr, sc, and 
 * newColor. You should perform a flood fill on the image starting from the pixel 
 * image[sr][sc]. To perform a flood fill, consider the starting pixel, plus any 
 * pixels connected 4-directionally to the starting pixel of the same color as 
 * the starting pixel, plus any pixels connected 4-directionally to those pixels 
 * (also with the same color), and so on. Replace the color of all of the aforementioned 
 * pixels with newColor. Return the modified image after performing the flood fill.
 * 
 * Example 1:
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., 
 * the red pixel), all pixels connected by a path of the same color as the starting 
 * pixel (i.e., the blue pixels) are colored with the new color. Note the bottom 
 * corner is not colored 2, because it is not 4-directionally connected to the 
 * starting pixel.
 * 
 * Constraints:
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], newColor < 216
 * 0 <= sr < m
 * 0 <= sc < n
 */

package queueStack;

import arrays.ArrayUtils;

public class FloodFill {
    
    private int[] dir = {0, 1, 0, -1, 0};

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        FloodFill f = new FloodFill();
        System.out.println("sr = " + sr + ", sc = " + sc + ", newColor = " + newColor);
        ArrayUtils u = new ArrayUtils();
        u.printMat(image);
        int[][] newImage = f.floodFill(image, sr, sc, newColor);
        u.printMat(newImage);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    /**
     * 如果当前元素坐标[sr,sc]没有越界且当前元素和oldColor值一样，则将该元素值设置为newColor，
     * 然后在当前元素的上下左右四个方向分别通过递归进行相同的处理
     * @param image
     * @param sr
     * @param sc
     * @param oldColor
     * @param newColor
     */
    private void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        for (int i = 0; i < dir.length - 1; i++) {
            fill(image, sr + dir[i], sc + dir[i + 1], oldColor, newColor);
        }
    }

}
