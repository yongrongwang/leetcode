package trie;

import java.util.LinkedList;
import java.util.List;

public class TrieNode {
    boolean isWord;
    int sum;
    TrieNode[] children;
    String word;
    
    public TrieNode(int size) {
        children = new TrieNode[size];
    }
}

class TrieNode2 {
    TrieNode2[] children;
    // 如果当前字符不是最后一个字符则为-1，否则是当前字符所在的字符串在数组中的索引，可以避免同
    // 一个字符串拼接在一起
    int index;
    // 在处理a短b长的时候，如果b多出来的部分构成回文字符串，直接将b所在的字符串在数组中的索引
    // 加进来，可以更加方便处理b多出来的部分
    List<Integer> list;
    
    public TrieNode2(int size) {
        children = new TrieNode2[size];
        index = -1;
        list = new LinkedList<Integer>();
    }
};
