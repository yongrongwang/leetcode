/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to 
 * efficiently store and retrieve keys in a dataset of strings. There are various 
 * applications of this data structure, such as autocomplete and spellchecker.
 * Implement the Trie class:
 * - Trie() Initializes the trie object.
 * - void insert(String word) Inserts the string word into the trie.
 * - boolean search(String word) Returns true if the string word is in the trie 
 *   (i.e., was inserted before), and false otherwise.
 * - boolean startsWith(String prefix) Returns true if there is a previously inserted 
 *   string word that has the prefix prefix, and false otherwise.
 * 
 * Example 1:
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * 
 * Constraints:
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
 */

package trie;

public class Trie {
    private TrieNode root;

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println("search 'apple': " + t.search("apple"));
        System.out.println("search 'app': " + t.search("app"));
        System.out.println("stats with 'app': " + t.startsWith("app"));
        t.insert("app");
        System.out.println("search 'app': " + t.search("app"));
    }
    
    public Trie() {
        root = new TrieNode(26);
    }
    
    /**
     * 遍历整个字符串，针对每个字符搜索trie，如果在当前节点的childre数组中没找到，则生成一个
     * 新节点并且将其加入到当前节点的children数组中，然后继续搜索trie
     * @param word
     */
    public void insert(String word) {
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
        TrieNode cur = searchWord(word);
        return cur != null && cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = searchWord(prefix);
        return cur != null;
    }
    
    /**
     * 遍历整个字符串，针对每个字符搜索trie，如果当前节点不为null则继续搜索trie，否则跳出循环
     * @param word
     * @return
     */
    private TrieNode searchWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur == null) {
                break;
            }
            int i = c - 'a';
            cur = cur.children[i];
        }
        return cur;
    }

}
