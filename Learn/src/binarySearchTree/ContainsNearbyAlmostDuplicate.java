/**
 * Given an integer array nums and two integers k and t, return true if there are 
 * two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t 
 * and abs(i - j) <= k.
 * 
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^4
 * 0 <= t <= 2^31 - 1
 */

package binarySearchTree;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
        int[] nums = {-2147483648,2147483647};
        int k = 1;
        int t = 1;
        ContainsNearbyAlmostDuplicate c = new ContainsNearbyAlmostDuplicate();
        System.out.println(c.containsNearbyAlmostDuplicate(nums, k, t));
    }
    
    /**
     * 使用set来保存k个数组中的元素，从左往右遍历数组，如果set中存在元素和当前元素的差值小于等于
     * t则返回true，否则将当前元素添加到set中，如果此时set中元素个数超过k个则删除最老的那个元素
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i]);
            Long ceil = set.ceiling((long) nums[i]);
            if ((floor != null && nums[i] - floor <= t) || 
                    (ceil != null && ceil - nums[i] <= t)) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}
