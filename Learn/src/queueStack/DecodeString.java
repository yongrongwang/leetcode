/**
 * Given an encoded string, return its decoded string. The encoding rule is: 
 * k[encoded_string], where the encoded_string inside the square brackets is being 
 * repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, 
 * square brackets are well-formed, etc. Furthermore, you may assume that the original 
 * data does not contain any digits and that digits are only for those repeat numbers, 
 * k. For example, there won't be input like 3a or 2[4].
 * 
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * 
 * Constraints:
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */

package queueStack;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        DecodeString d = new DecodeString();
        System.out.println(d.decodeString(s));;
    }
    
    /**
     * 两个堆栈，stack1存放数字，stack2存放字符串，两个变量，变量num保存临时数字，变量builder保存
     * 临时字符串，当前字符分为四种情况处理
     * 1. 如果是'['：往stack1中压入num，往stack2中压入builder，然后分别重置num和builder
     * 2. 如果是']'：从stack1中弹出一个元素作为循环次数num，从stack2中弹出一个元素作为子串temp，
     *    然后在builder后面拼接num次子串temp
     * 3. 如果是数字的一部分：之前值num乘以10后加上当前值
     * 4. 如果是字符串的一部分：在之前字符串builder后面拼接当前字符
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<StringBuilder> stack2 = new Stack<StringBuilder>();
        int num = 0;
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack1.push(num);
                stack2.push(builder);
                num = 0;
                builder = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder temp = builder;
                builder = stack2.pop();
                for (int i = stack1.pop(); i > 0 ; i--) {
                    builder.append(temp);
                }
            } else if (ch >= '0' && ch <= '9') {
                num = 10 * num + (ch - '0');
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

}
