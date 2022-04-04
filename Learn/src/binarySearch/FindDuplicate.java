/**
 * Given an array of integers nums containing n + 1 integers where each integer 
 * is in the range [1, n] inclusive. There is only one repeated number in nums, 
 * return this repeated number. You must solve the problem without modifying the 
 * array nums and uses only constant extra space.
 * 
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * 
 * Constraints:
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which 
 * appears two or more times.
 */

package binarySearch;

import java.util.Arrays;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        FindDuplicate f = new FindDuplicate();
        System.out.println(Arrays.toString(nums));
        System.out.println(f.findDuplicate(nums));
    }
    
    /**
     * 寻找重复的数字类似于寻找链表的环入口，使用一快一慢两个指针从起点出发，快指针一次走两步，
     * 慢指针一次走一步，两者必定相遇在环中的某一点，相遇后将快指针重置为起点，之后快指针和慢指是
     * 针都一次走一步，它们最终相遇的节点即为环入口节点，即为重复的数字
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
