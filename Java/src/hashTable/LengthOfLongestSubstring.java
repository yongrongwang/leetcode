/**
 * Given a string s, find the length of the longest substring without repeating 
 * characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */

package hashTable;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring(s));
    }
    
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] indexs = new int[256];
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = -1;
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (indexs[s.charAt(i)] != -1) {
                j = Math.max(j, indexs[s.charAt(i)] + 1);
            }
            indexs[s.charAt(i)] = i;
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

}
