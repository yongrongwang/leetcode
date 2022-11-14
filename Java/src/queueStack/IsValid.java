/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 */

package queueStack;

import java.util.Stack;

public class IsValid {

	public static void main(String[] args) {
		String s = "{[()]";
		IsValid i = new IsValid();
		System.out.println(i.isValid(s));
	}

	/**
	 * 针对字符串中的每一个字符进行判断，每次遇到一个左括号字符就将匹配的右括号字符压入栈中，否则
	 * 如果堆栈为空或者当前字符不等于弹出的字符则返回false
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(')');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
        return stack.isEmpty();
    }
}
