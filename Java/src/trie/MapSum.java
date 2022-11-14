/**
 * Design a map that allows you to do the following:
 * - Maps a string key to a given value.
 * - Returns the sum of the values that have a key with a prefix equal to a given 
 *   string.
 * Implement the MapSum class:
 * - MapSum() Initializes the MapSum object.
 * - void insert(String key, int val) Inserts the key-val pair into the map. If 
 *   the key already existed, the original key-value pair will be overridden to 
 *   the new one.
 * - int sum(string prefix) Returns the sum of all the pairs' value whose key starts 
 *   with the prefix.
 * 
 * Example 1:
 * Input
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * Output
 * [null, null, 3, null, 5]
 * Explanation
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);  
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);    
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 * 
 * Constraints:
 * 1 <= key.length, prefix.length <= 50
 * key and prefix consist of only lowercase English letters.
 * 1 <= val <= 1000
 * At most 50 calls will be made to insert and sum.
 */

package trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    private TrieNode root;
    private Map<String, Integer> map = new HashMap<String, Integer>();
    
    public static void main(String[] args) {
        MapSum m = new MapSum();
        m.insert("apple", 3);  
        System.out.println(m.sum("ap"));;
        m.insert("app", 2);
        System.out.println(m.sum("ap"));;
    }
    
    public MapSum() {
        root = new TrieNode(26);
    }
    
    /**
     * 遍历整个字符串，针对每个字符搜索trie，如果在当前节点的childre数组中没找到，则生成一个
     * 新节点并且将其加入到当前节点的children数组中，并把当前节点的sum加上旧值和新值的差值，
     * 然后继续搜索trie
     * @param key
     * @param val
     */
    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        if (diff == 0) {
            return;
        }
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode(26);
            }
            cur = cur.children[i];
            cur.sum += diff;
        }
        map.put(key, val);
    }
    
    /**
     * 遍历整个字符串，针对每个字符搜索trie，如果当前节点不为null则继续搜索trie，否则跳出循环，
     * 最后返回当前节点的sum
     * @param prefix
     * @return
     */
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur == null) {
                break;
            }
            int i = c - 'a';
            cur = cur.children[i];
        }
        return cur == null ? 0 : cur.sum;
    }
}
