/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must appear as many times as it shows in both arrays 
 * and you may return the result in any order.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * 
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */

package binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Intersect {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Intersect i = new Intersect();
        System.out.println(Arrays.toString(i.intersect(nums1, nums2)));
    }
    
    /**
     * 一个Map用来存储第一个数组中的元素和对应的频率，一个List在第二个数组中的元素出现在Map且
     * 对应的频率大于0的时候就存储该元素，然后再将对应的频率减一，最后将List转换成数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> intersect = new LinkedList<Integer>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                intersect.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] result = new int[intersect.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = intersect.get(i); 
        }
        return result;
    }

}
