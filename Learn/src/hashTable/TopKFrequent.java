/**
 * Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10^5
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 */

package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,3,3};
        int k = 2;
        TopKFrequent t = new TopKFrequent();
        System.out.println(Arrays.toString(t.topKFrequent(nums, k)));
    }
    
    /**
     * 使用桶排序，首先使用一个map统计原数组所有元素出现的频率，然后将频率作为索引，将所有出现
     * 相同频率的元素组成一个数组作为元素，构成一个新的数组，最后从后往前遍历新数组，返回出现频
     * 率最高的k个元素
     * @param nums
     * @param k
     * @return
     */
    @SuppressWarnings("unchecked")
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer>[] bucket = new List[nums.length + 1];
        int[] result = new int[k];
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++, k--) {
                    if (k == 0) {
                        return result;
                    }
                    result[k - 1] = bucket[i].get(j);
                }
            }
        }
        return result;
    }

}
