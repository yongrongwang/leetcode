package arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of
 * the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100]. After sorting,
 * it becomes [0,1,9,16,100].
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -104 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        SortedSquares s = new SortedSquares();
        ArrayUtils a = new ArrayUtils();
        a.printArray(nums);
        int[] sorted = s.sortedSquares(nums);
        a.printArray(sorted);
    }

    /**
     * 两指针在原数组上从两边往中间滑动，将绝对值大的平方后依次由后往前放到目标数组上
     */
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0;
        int j = n - 1;

        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                sorted[p] =  nums[i] * nums[i];
                i++;
            } else {
                sorted[p] = nums[j] * nums[j];
                j--;
            }
        }

        return sorted;
    }


}
