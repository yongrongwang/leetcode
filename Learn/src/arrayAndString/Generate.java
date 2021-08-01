package arrayAndString;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle. In
 * Pascal's triangle, each number is the sum of the two numbers directly above it
 * as shown:
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Constraints:
 * 1 <= numRows <= 30
 */
public class Generate {

    public static void main(String[] args) {
        Generate g = new Generate();
        int numRows = 4;
        List<List<Integer>> l = g.generate(numRows);
        System.out.println(l);
    }

    /**
     * 循环利用每一行结果，每次先在行首插入1，然后从索引1开始从左往右扫描，每个元素设置为该元素
     * 和后一个元素之和，最后复制这一行结果后加入数组
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            rows.add(new ArrayList<Integer>(row));
        }

        return rows;
    }

}
