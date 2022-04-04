/**
 * Given a string s, find the first non-repeating character in it and return its 
 * index. If it does not exist, return -1.
 * 
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * 
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of only lowercase English letters.
 */

package hashTable;

public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "leetcode";
        FirstUniqChar f = new FirstUniqChar();
        System.out.println(f.firstUniqChar(s));
    }
    
    /**
     * 使用将字符作为索引的数组来保存s中的字符对应的出现次数，如果当前字符出现次数为1则返回
     * 对应的索引
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
