package com.wjw.lintcode.simple;

import java.util.Stack;

public class _有效的括号序列 {

	public static void main(String[] args) {
		boolean validParentheses = isValidParentheses("([])");
		System.out.println(validParentheses);
	}

	public static boolean isValidParentheses(String s) {
		// write your code here
		Stack<Character> stack = new Stack<>();
		char[] charArray = s.toCharArray();

		for (char value : charArray) {
			if (value == ')' && !stack.isEmpty() && stack.pop() == '(') {
				continue;
			} else if (value == '}' && !stack.isEmpty() && stack.pop() == '{') {
				continue;
			} else if (value == ']' && !stack.isEmpty() && stack.pop() == '[') {
				continue;
			}
			stack.push(value);
		}

		return stack.isEmpty();
	}
}
