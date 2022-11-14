/**
 * Given an integer array nums and an integer k, return true if there are two distinct 
 * indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 0 <= k <= 10^5
 */

package hashTable;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 3;
        ContainsNearbyDuplicate c = new ContainsNearbyDuplicate();
        System.out.println(c.containsNearbyDuplicate(nums, k));
    }
    
    /**
     * 在遍历数组过程中使用map来记录元素值和对应的索引，如果该元素值不是第一次出现，就计算当前
     * 索引和上一次出现时的索引差值，如果差值小于k则返回true
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
