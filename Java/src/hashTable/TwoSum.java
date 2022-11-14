/**
 * Given an array of integers nums and an integer target, return indices of the 
 * two numbers such that they add up to target. You may assume that each input would 
 * have exactly one solution, and you may not use the same element twice. You can 
 * return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Constraints:
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 */

package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        TwoSum t = new TwoSum();
        System.out.println(Arrays.toString(t.twoSum(nums, target)));
    }
    
    /**
     * 遍历数组，每次遇到一个元素就保存目标值和元素值之差以及对应索引，当目标值和元素值之差等于
     * 某个元素的时候则返回true
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1,-1};
    }

}
