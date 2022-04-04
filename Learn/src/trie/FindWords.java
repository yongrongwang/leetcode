/**
 * Given an m x n board of characters and a list of strings words, return all words 
 * on the board. Each word must be constructed from letters of sequentially adjacent 
 * cells, where adjacent cells are horizontally or vertically neighboring. The same 
 * letter cell may not be used more than once in a word.
 * 
 * Example 1:
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], 
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * 
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 10^4
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */

package trie;

import java.util.LinkedList;
import java.util.List;

public class FindWords {
    private TrieNode root;

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        FindWords f = new FindWords();
        System.out.println(f.findWords(board, words));;
    }
    
    public FindWords() {
        root = new TrieNode(26);
    }
    
    /**
     * board = [["o","a","a","n"],
     *          ["e","t","a","e"],
     *          ["i","h","k","r"],
     *          ["i","f","l","v"]]
     * words = ["oath","pea","eat","rain"]
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        build(words);
        return search(board);
    }
    
    private void build(String[] words) {
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) {
                    cur.children[i] = new TrieNode(26);
                }
                cur = cur.children[i];
            }
            cur.word = word;
        }
    }
    
    private List<String> search(char[][] board) {
        List<String> list = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                match(board, i, j, root, list);
            }
        }
        return list;
    }
    
    /**
     * 递归法，遍历字符数组，针对每个字符搜索trie，如果当前节点不为null且没有访问过则继续搜索
     * trie。如果当前字符匹配成功，则将当前字符的相邻四个方向的字符和当前节点的每个孩子节点进行
     * 递归匹配，如果存在孩子节点匹配成功则将该节点的字符串存储到结果数组中，并且将该节点的字符
     * 串置为null以避免重复访问。为了避免使用一个boolean数组表示字符数组中的字符是否访问过，
     * 将对应字符置为'$'并且在相邻四个方向的字符访问结束后重置为原来的字符
     * @param board
     * @param row
     * @param column
     * @param node
     * @param list
     */
    private void match(char[][] board, int row, int column, TrieNode node, List<String> list) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return;
        }
        char c = board[row][column];
        int i = c - 'a';
        if (c =='$' || i < 0 || i >= node.children.length || node.children[i] == null) {
            return;
        }
        node = node.children[i];
        if (node.word != null) {
            list.add(node.word);
            node.word = null;
        }
        board[row][column] = '$';
        match(board, row - 1, column, node, list);
        match(board, row + 1, column, node, list);
        match(board, row, column - 1, node, list);
        match(board, row, column + 1, node, list);
        board[row][column] = c;
    }

}