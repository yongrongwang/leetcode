/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
 * the median of the two sorted arrays. The overall run time complexity should be 
 * O(log (m+n)).
 * 
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 */

package binarySearch;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {0,0};
        int[] nums2 = {0,0};
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        System.out.println(f.findMedianSortedArrays(nums1, nums2));
        System.out.println(f.findMedianSortedArrays2(nums1, nums2));
    }
    
    /**
     * 递归法
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        double med = getKth(nums1, 0, nums2, 0, (n1 + n2 + 1) / 2);
        if ((n1 + n2) % 2 == 0) {
            med = (med + getKth(nums1, 0, nums2, 0, (n1 + n2 + 2) / 2)) / 2.0;
        }
        return med;
    }
    
    /**
     * 如果med1小于med2，则保留nums1右半部分和nums2左半部分，否则保留nums1左半部分和nums2
     * 右半部分，其中med1和med2分别为nums1和nums2中间索引的数值
     * @param nums1
     * @param start1
     * @param nums2
     * @param start2
     * @param k
     * @return
     */
    public double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + k / 2 - 1;
        int j = start2 + k / 2 - 1;
        int med1 = (i < nums1.length ? nums1[i] : Integer.MAX_VALUE);
        int med2 = (j < nums2.length ? nums2[j] : Integer.MAX_VALUE);
        if (med1 < med2) {
            return getKth(nums1, i + 1, nums2, start2, k - k / 2);
        } else {
            return getKth(nums1, start1, nums2, j + 1, k - k / 2);
        }
    }
    
    /**
     * 将两个数组拼接成的数组分成LEFT和RIGHT左右两部分，如果能保证左右两边长度相等且左边最大
     * 值小于等于右边最小值，则中位数等于LEFT中的最小值加上RIGHT中的最大值后取平均值。将第一
     * 个数组平均分成LEFT1和RIGHT1左右两部分，将第二个数组分成LEFT2和RIGHT2左右两部分，从第
     * 二个数组中取LEFT2，然后从第一个数组中取LFET1或者RIGHT1拼接成LEFT。为了确保第二个数组
     * 中的LEFT1不为空，需要确保第一个数组长度小于等于第二个数组。如果LFET1中的最大值小于LEFT2
     * 中的最大值，则从第一个数组中取较大的RIGHT1，否则从第一个数组中取较小的LEFT1。最后从LEFT1
     * 的最大值和LEFT2的最大值中取较大值作为LEFT的最大值，从RIGHT1的最小值和RIGHT2的最小值
     * 取较小值作为RIGHT的最小值
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int mid = (n1 + n2 - 1) / 2;
        int left1 = 0;
        int right1 = Math.min(n1, mid);
        while (left1 < right1) {
            int mid1 = left1 + (right1 - left1) / 2;
            int mid2 = mid - mid1;
            if (nums1[mid1] < nums2[mid2]) {
                left1 = mid1 + 1;
            } else {
                right1 = mid1;
            }
        }
        int val1 = (left1 - 1 >= 0 ? nums1[left1 - 1] : Integer.MIN_VALUE);
        int val2 = (mid - left1 >= 0 ? nums2[mid - left1] : Integer.MIN_VALUE);
        double med = Math.max(val1, val2);
        if ((n1 + n2) % 2 == 0) {
            val1 = (left1 < n1 ? nums1[left1] : Integer.MAX_VALUE);
            val2 = (mid - left1 + 1 < n2 ? nums2[mid - left1 + 1] : Integer.MAX_VALUE);
            med = (med + Math.min(val1, val2)) / 2.0;
        }
        return med;
    }

}
