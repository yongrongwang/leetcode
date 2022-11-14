package arrays;

import java.util.HashSet;

/**
 * Given an array arr of integers, check if there exists two integers N and M such
 * that N is the double of M ( i.e. N = 2 * M). More formally check if there exists
 * two indices i and j such that :
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 * Example 1:
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 *
 * Constraints:
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class CheckIfExist {

    public static void main(String[] args) {
        int[] nums = {10,2,5,3};
        CheckIfExist c = new CheckIfExist();
        boolean f = c.checkIfExist(nums);
        System.out.println(f);
    }

    /**
     * 从左往右遍历数组，每个元素乘以2或者除以2后都不等于之前的元素，则将该元素放入HashSet，
     * 否则返回true
     */
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] * 2) || (arr[i] % 2 == 0 && set.contains(arr[i] / 2))) {
                return true;
            }
            set.add(arr[i]);
        }

        return false;
    }

}
