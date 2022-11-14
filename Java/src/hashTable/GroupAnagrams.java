/**
 * Given an array of strings strs, group the anagrams together. You can return the 
 * answer in any order. An Anagram is a word or phrase formed by rearranging the 
 * letters of a different word or phrase, typically using all the original letters 
 * exactly once. 
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.groupAnagrams(strs));
    }
    
    /**
     * 遍历数组时使用map来保存元素信息，键是一个长度为26的字符串，每个字符表示原来数组中字符串
     * 的字符出现的次数，值是原来数组中可以用相同键表示的字符串
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] freq = new char[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<String>());
            }
            map.get(key).add(s);
        }
        return new LinkedList<List<String>>(map.values());
    }

}
