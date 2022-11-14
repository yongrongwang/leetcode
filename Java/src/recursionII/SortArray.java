/**
 * Given an array of integers nums, sort the array in ascending order.
 *
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 *
 * Constraints:
 * 1 <= nums.length <= 5 * 10^4
 * -5 * 10^4 <= nums[i] <= 5 * 10^4
 */

package recursionII;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] nums = { 5, 2, 3, 1 };
        System.out.println(Arrays.toString(nums));
        SortArray s = new SortArray();
        System.out.println(Arrays.toString(s.sortArray(nums)));
    }

    public int[] sortArray(int[] nums) {
//        mergeSort(nums, 0, nums.length - 1);
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 归并排序：分为三步，分解，递归排序，合并
     * @param nums
     * @param left
     * @param right
     */
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    /**
     * 归并排序的合并部分：首先创建两个临时数组保存[left,mid]和[mid+1,right]的元素，然后从
     * 左向右迭代两个数组，每次对比两个数组当前元素，取其中较小的元素放入原数组
     * @param nums
     * @param left 原数组左边界
     * @param mid 原数组中点
     * @param right 原数组右边界
     */
    private void merge(int[] nums, int left, int mid, int right) {
        int[] nums1 = Arrays.copyOfRange(nums, left, mid + 1);
        int[] nums2 = Arrays.copyOfRange(nums, mid + 1, right + 1);
        int m = nums1.length;
        int n = nums2.length;
        int i = left;
        int l = 0;
        int r = 0;
        while (l < m || r < n) {
            if (r >= n || (l < m && nums1[l] < nums2[r])) {
                nums[i++] = nums1[l++];
            } else {
                nums[i++] = nums2[r++];
            }
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid);
        quickSort(nums, mid + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
