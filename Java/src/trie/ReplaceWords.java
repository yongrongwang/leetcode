/**
 * In English, we have a concept called root, which can be followed by some other 
 * word to form another longer word - let's call this word successor. For example, 
 * when the root "an" is followed by the successor word "other", we can form a new 
 * word "another". Given a dictionary consisting of many roots and a sentence consisting 
 * of words separated by spaces, replace all the successors in the sentence with 
 * the root forming it. If a successor can be replaced by more than one root, replace 
 * it with the root that has the shortest length. Return the sentence after the 
 * replacement.
 * 
 * Example 1:
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * 
 * Constraints:
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] consists of only lower-case letters.
 * 1 <= sentence.length <= 10^6
 * sentence consists of only lower-case letters and spaces.
 * The number of words in sentence is in the range [1, 1000]
 * The length of each word in sentence is in the range [1, 1000]
 * Every two consecutive words in sentence will be separated by exactly one space.
 * sentence does not have leading or trailing spaces.
 */

package trie;

import java.util.LinkedList;
import java.util.List;

public class ReplaceWords {
    private TrieNode root;

    public static void main(String[] args) {
        ReplaceWords r = new ReplaceWords();
        List<String> dictionary = new LinkedList<String>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(r.replaceWords(dictionary, sentence));
    }
    
    public ReplaceWords() {
        root = new TrieNode(26);
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        build(dictionary);
        return replace(root, sentence);
    }
    
    /**
     * 遍历数组中的每个字符串，针对每个字符搜索trie，如果在当前节点的childre数组中没找到，则
     * 生成一个新节点并且将其加入到当前节点的children数组中，然后继续搜索trie
     * @param dictionary
     * @return
     */
    private void build(List<String> dictionary) {
        for (String word : dictionary) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.isWord) {
                    break;
                }
                int i = c - 'a';
                if (cur.children[i] == null) {
                    cur.children[i] = new TrieNode(26);
                }
                cur = cur.children[i];
            }
            cur.isWord = true;
        }
    }
    
    /**
     * 首先分割原来字符串得到字符串数组，然后遍历每个字符串，针对每个字符搜索trie，如果当前节点
     * 不为null则继续搜索trie，否则跳出循环
     * @param word
     * @return
     */
    private String replace(TrieNode root, String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            for (int j = 0; j < words[i].length() && cur != null; j++) {
                int k = words[i].charAt(j) - 'a';
                cur = cur.children[k];
                if (cur != null && cur.isWord) {
                    words[i] =  words[i].substring(0, j + 1);
                }
            }
        }
        return String.join(" ", words);
    }

}
