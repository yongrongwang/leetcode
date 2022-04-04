/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must be unique and you may return the result in any order.
 * 
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */

package binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        Intersection i = new Intersection();
        System.out.println(Arrays.toString(i.intersection(nums1, nums2)));
        System.out.println(Arrays.toString(i.intersection2(nums1, nums2)));
    }
    
    /**
     * 第一个集合用来存储第一个数组中的元素，第二个集合在第二个数组中的元素出现在第一个集合的时候
     * 就存储该元素，最后将第二个集合转换成数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (int num : intersect) {
            result[i++] = num; 
        }
        return result;
    }
    
    /**
     * 首先对较短的数组进行排序，然后遍历较长的数组，如果当前元素可以在较短的数组中通过二分搜素
     * 找到，则将其添加到集合中，最后将集合转换成数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums2) {
            if (binarySearch(nums1, num)) {
                set.add(num);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
