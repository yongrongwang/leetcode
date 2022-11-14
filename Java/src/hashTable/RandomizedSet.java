/**
 * Implement the RandomizedSet class:
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
* You must implement the functions of the class such that each function works in average O(1) time complexity.
* 
* Example 1:
* Input
* ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
* [[], [1], [2], [2], [], [1], [2], []]
* Output
* [null, true, false, true, 2, true, false, 2]
* Explanation
* RandomizedSet randomizedSet = new RandomizedSet();
* randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
* randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
* randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
* randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
* randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
* randomizedSet.insert(2); // 2 was already in the set, so return false.
* randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
* 
* Constraints:
* -2^31 <= val <= 2^31 - 1
* At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
* There will be at least one element in the data structure when getRandom is called.
 */

package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> numToIndex;
    Random rand;

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(1));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(3));
        System.out.println(obj.remove(3));
        System.out.println(obj.getRandom());
    }
    
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        numToIndex = new HashMap<Integer, Integer>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (numToIndex.containsKey(val)) {
            return false;
        }
        nums.add(val);
        numToIndex.put(val, nums.size() - 1);
        return true;
    }
    
    /**
     * 使用map来快速查找元素值对应的索引位置，如果待删除的元素不是最后一个元素，首先复制最后一
     * 个元素到待删除的元素且重新设置map中最后一个元素的索引位置，然后删除最后一个元素和map中
     * 待删除元素的索引位置
     * @param val
     * @return
     */
    public boolean remove(int val) {
        if (!numToIndex.containsKey(val)) {
            return false;
        }
        int cur = numToIndex.get(val);
        int last = nums.size() - 1;
        if (cur != last) {
            int lastNum = nums.get(last);
            nums.set(cur, lastNum);
            numToIndex.put(lastNum, cur);
        }
        nums.remove(last);
        numToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }

}
