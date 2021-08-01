package arrays;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 */
public class FindMaxConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] nums = {1,0,1,1,0,1};
	    FindMaxConsecutiveOnes f = new FindMaxConsecutiveOnes();
	    int max = f.findMaxConsecutiveOnes(nums);
	    System.out.println("The max length is " + max);
	}

	public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
		}

        return max;
    }

}
