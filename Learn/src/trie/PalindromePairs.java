/**
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) 
 * in the given list, so that the concatenation of the two words words[i] + words[j] 
 * is a palindrome.
 * 
 * Example 1:
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * Constraints:
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] consists of lower-case English letters.
 */

package trie;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PalindromePairs {
    TrieNode2 root;
    
    public PalindromePairs() {
        root = new TrieNode2(26);
    }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        PalindromePairs p = new PalindromePairs();
        System.out.println("result = " + p.palindromePairs(words));
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        build(words);
        return search(words);
    }
    
    /**
     * 遍历字符串数组，针对每个字符串从后往前扫描来构建Trie
     * @param words
     */
    private void build(String[] words) {
        for (int i = 0; i < words.length; i++) {
            TrieNode2 cur = root;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                int k = words[i].charAt(j) - 'a';
                if (cur.children[k] == null) {
                    cur.children[k] = new TrieNode2(26);
                }
                // a短b长，方便处理b多出来的部分
                if (isPalindrome(words[i], 0, j)) {
                    cur.list.add(i);
                }
                cur = cur.children[k];
            }
            cur.list.add(i);
            cur.index = i;
        }
    }
    
    /**
     * 遍历字符串数组，针对每个字符串从前往后扫描来搜索能拼接成回文字符串的两个字符串，假设要拼
     * 接的两个字符串分别是a和b，且a后面拼接b，则需要讨论两种情况
     * 1. a长b短：a前半部分+a后半部分+b，则b反转后等于a的前半部分，且a的后半部分是回文字符串
     * 2. a短b长：a+b前半部分+b后半部分，则b的后半部分反转后等于a，且b的前半部分是回文字符串
     * @param words
     * @return
     */
    private List<List<Integer>> search(String[] words) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            TrieNode2 cur = root;
            for (int j = 0; j < words[i].length() && cur != null; j++) {
                // a长b短，检测a多出来的部分
                if (cur.index >= 0 && cur.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                    result.add(Arrays.asList(i, cur.index));
                }
                int k = words[i].charAt(j) - 'a';
                cur = cur.children[k];
            }
            // a短b长，检测b多出来的部分
            if (cur != null) {
                for (int index : cur.list) {
                    if (index == i) {
                        continue;
                    }
                    result.add(Arrays.asList(i, index));
                }
            }
        }
        return result;
    }
    
    /**
     * 检查字符串的[start,end]区间的子字符串是否构成回文字符串
     * @param word
     * @param start
     * @param end
     * @return
     */
    private boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
