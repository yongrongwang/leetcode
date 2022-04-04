/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's
 * triangle. In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Constraints:
 * 0 <= rowIndex <= 33
 */

package arrayAndString;

import java.util.Arrays;
import java.util.List;

public class GetRow {

    public static void main(String[] args) {
        GetRow g = new GetRow();
        for (int i = 0; i < 6; i++) {
            System.out.println(g.getRow(i));
        }
    }

    /**
     * 先初始化一个长度为rowIndex+1的数组，并且设置索引为0的元素为1，然后计算每一行数据。针对
     * 每一行数据，从最后一个元素开始往前直到索引为1的元素，每个元素设置为当前元素值和前一个元素
     * 值之和
     */
    public List<Integer> getRow(int rowIndex) {
        Integer[] nums = new Integer[rowIndex + 1];
        Arrays.fill(nums, 0);
        nums[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                nums[j] += nums[j - 1];
            }
        }

        return Arrays.asList(nums);
    }

}
