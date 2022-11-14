/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return 
 * the number of tuples (i, j, k, l) such that:
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 
* Example 1:
* Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
* Output: 2
* Explanation:
* The two tuples are:
* 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
* 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
* 
* Constraints:
* n == nums1.length
* n == nums2.length
* n == nums3.length
* n == nums4.length
* 1 <= n <= 200
* -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 */

package hashTable;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount {

    public static void main(String[] args) {
        int[] nums1 = {-1,-1}; 
        int[] nums2 = {-1,1};
        int[] nums3 = {-1,1};
        int[] nums4 = {1,-1};
        FourSumCount f = new FourSumCount();
        System.out.println(f.fourSumCount(nums1, nums2, nums3, nums4));
    }
    
    /**
     * 四个数组分成两组，求出第一组中所有可能的两个数组组合的两元素之和作为键，出现的次数作为值
     * 存储在map中，如果第二组中所有可能的两个数组组合的两元素之和的相反数出现在了map中，则计数
     * 值加一
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                count += map.getOrDefault(-(n3 + n4), 0);
            }
        }
        return count;
    }

}
