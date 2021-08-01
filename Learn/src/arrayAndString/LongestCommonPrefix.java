package arrayAndString;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings. If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","fl"]
 * Output: "fl"
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"a"};
        LongestCommonPrefix l = new LongestCommonPrefix();
        String s = l.longestCommonPrefix(strs);
        System.out.println("s = " + s);
    }

    /**
     * 数组从前往右扫描，将挨着的两个字符串进行比对，每次找出相同的字符串长度，然后得到当前最
     * 长相同字符串长度，扫描结束得到所有字符串的相同字符串长度
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int length = strs[0].length();
        int j = 0;
        for (int i = 0; i < strs.length - 1; i++) {
            for (j = 0; j < length && j < strs[i + 1].length() &&
                    strs[i].charAt(j) == strs[i + 1].charAt(j); j++) {
            }
            length = j;
        }

        return strs[0].substring(0, j);
    }

}
