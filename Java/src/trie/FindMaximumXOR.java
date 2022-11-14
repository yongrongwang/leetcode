/**
 * Given an integer array nums, return the maximum result of nums[i] XOR nums[j], 
 * where 0 <= i <= j < n.
 * 
 * Example 1:
 * Input: nums = [3,10,5,25,2,8]
 * Output: 28
 * Explanation: The maximum result is 5 XOR 25 = 28.
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 10^5
 * 0 <= nums[i] <= 2^31 - 1
 */

package trie;

public class FindMaximumXOR {
    private TrieNode root;

    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        FindMaximumXOR f = new FindMaximumXOR();
        System.out.println(f.findMaximumXOR(nums));
    }
    
    public FindMaximumXOR() {
        root = new TrieNode(2);
    }
    
    public int findMaximumXOR(int[] nums) {
        insert(nums);
        return search(nums);
    }
    
    public void insert(int[] nums) {
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i--) {
                int j = (num >> i) & 1;
                if (cur.children[j] == null) {
                    cur.children[j] = new TrieNode(2);
                }
                cur = cur.children[j];
            }
        }
    }
    
    /**
     *    5 = 00101
     * ^ 25 = 11001
     *   28 = 11100
     * 针对数组中的每个元素，对当前数字的二进制形式从最高位往最低位扫描，然后通过将当前数字右移
     * i位并且和1按位与得到二进制形式的第i位，因为要使得异或后的结果最大，所以希望1减去第i位的
     * 结果在Trie中，如果希望得到的结果确实在树中，则将sum的该位置成1并且继续搜索下一位，否则
     * 只是搜索下一位，最后最大的sum即为数组中任意两个元素的最大异或结果
     * @param nums
     * @return
     */
    private int search(int[] nums) {
        int max = 0;
        for (int num : nums) {
            TrieNode cur = root;
            int sum = 0;
            for (int i = 31; i >= 0; i--) {
                int j = 1 - ((num >> i) & 1);
                if (cur.children[j] != null) {
                    sum |= 1 << i;
                    cur = cur.children[j];
                } else {
                    cur = cur.children[1 - j];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
    
}