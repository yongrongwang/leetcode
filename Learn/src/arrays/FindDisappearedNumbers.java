package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return
 * an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDisappearedNumbers f = new FindDisappearedNumbers();
        List<Integer> l = f.findDisappearedNumbers(nums);
        System.out.println(l);
    }

    /**
     * 从左往右扫描数组，当元素索引加一不等于元素值a，且元素值a不等于元素值减一后为索引所对应的
     * 元素值b的时候，就交换a和b，结束后再次扫描数组，如果元素索引加一不等于元素值则加入到结果数组
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            while (i + 1 != nums[i] && nums[i] != nums[nums[i] - 1]) {
                int t = nums[i];
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                list.add(i + 1);
            }
        }

        return list;
    }

}
