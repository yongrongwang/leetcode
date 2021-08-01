package arrays;

import utils.ArrayUtils;

/**
 * Given an array arr, replace every element in that array with the greatest element
 * among the elements to its right, and replace the last element with -1.After
 * doing so, return the array.
 *
 * Example 1:
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * Explanation:
 * - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * - index 5 --> there are no elements to the right of index 5, so we put -1.
 *
 * Constraints:
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */
public class ReplaceElements {

    public static void main(String[] args) {
        int[] nums = {10,2,5,3};
        ReplaceElements r = new ReplaceElements();
        ArrayUtils a = new ArrayUtils();
        a.printArray(nums);
        nums = r.replaceElements(nums);
        a.printArray(nums);
    }

    /**
     * 从右往左扫描，先保存当前位置元素值，然后在当前位置保存右边所有元素最大值，最后更新右边所
     * 有元素最大值
     */
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = -1;
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }

}
