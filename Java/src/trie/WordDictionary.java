/**
 * Design a data structure that supports adding new words and finding if a string 
 * matches any previously added string.
 * Implement the WordDictionary class:
 * - WordDictionary() Initializes the object.
 * - void addWord(word) Adds word to the data structure, it can be matched later.
 * - bool search(word) Returns true if there is any string in the data structure that 
 *   matches word or false otherwise. word may contain dots '.' where dots can be  
 *   matched with any letter.
 * 
 * Example:
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 * 
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 * 
 * Constraints:
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 3 dots in word for search queries.
 * At most 10^4 calls will be made to addWord and search.
 */

package trie;

public class WordDictionary {
    private TrieNode root;

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("at");
        w.addWord("and");
        w.addWord("an");
        w.addWord("add");
        System.out.println(w.search("a"));
        System.out.println(w.search(".at"));
        w.addWord("bat");
        System.out.println(w.search(".at"));
    }
    
    public WordDictionary() {
        root = new TrieNode(26);
    }
    
    /**
     * 遍历整个字符串，针对每个字符搜索trie，如果在当前节点的childre数组中没找到，则生成一个
     * 新节点并且将其加入到当前节点的children数组中，然后继续搜索trie
     * @param word
     */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode(26);
            }
            cur = cur.children[i];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    /**
     * 递归法，遍历整个字符串，针对每个字符搜索trie，如果当前节点不为null则继续搜索trie。如果
     * 当前字符不为'.'，则递归匹配下一个字符；否则递归匹配当前节点的每个孩子节点，如果存在孩子
     * 节点匹配成功则直接返回true，否则返回false
     * @param chs
     * @param k
     * @param node
     * @return
     */
    private boolean match(char[] chs, int k, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (k == chs.length) {
            return node.isWord;
        }
        if (chs[k] != '.') {
            return match(chs, k + 1, node.children[chs[k] - 'a']);
        }
        for (TrieNode child : node.children) {
            if (match(chs, k + 1, child)) {
                return true;
            }
        }
        return false;
    }

}
