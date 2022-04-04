/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, and /. Each operand may be an integer or another 
 * expression.
 * Note that division between two integers should truncate toward zero.
 * It is guaranteed that the given RPN expression is always valid. That means the 
 * expression would always evaluate to a result, and there will not be any division 
 * by zero operation.
 * 
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * Constraints:
 * 1 <= tokens.length <= 10^4
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the 
 * range [-200, 200].
 */

package queueStack;

import java.util.Stack;

public class EvalRPN {

	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		EvalRPN e = new EvalRPN();
		System.out.println(e.evalRPN(tokens));;
	}
	
	/**
	 * 遍历整个数组，如果是数字则压入栈中，如果是符号则从栈中弹出两个数字，先弹出的放右边，后弹出
	 * 的放左边，符号放中间，计算结果压入栈中，最后弹出栈中唯一的数字作为最终计算结果
	 * @param tokens
	 * @return
	 */
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		String operators = "+-*/";
        for (int i = 0; i < tokens.length; i++) {
        	if (operators.contains(tokens[i])) {
        		int num1 = stack.pop();
        		int num2 = stack.pop();
        		if (tokens[i].equals("+")) {
            		stack.push(num2 + num1);
    			} else if (tokens[i].equals("-")) {
            		stack.push(num2 - num1);
    			} else if (tokens[i].equals("*")) {
            		stack.push(num2 * num1);
    			} else if (tokens[i].equals("/")) {
            		stack.push(num2 / num1);
    			} 
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
        return stack.pop();
    }

}
