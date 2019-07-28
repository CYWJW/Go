package com.wjw.lintcode.difficulty;

import java.util.HashMap;
import java.util.Stack;

import com.wjw.lintcode.difficulty._直方图最大矩形覆盖.Node;

public class _直方图最大矩形覆盖 {
	static class Node {
		int index;
		int value;

		public Node(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		int max = largestRectangleArea(new int[] {1,1});
		System.out.println(max);
	}

	public static int largestRectangleArea(int[] height) {
		// write your code here
		int result = 0;
		Stack<Node> stack = new Stack<>();
		for (int i = 0; i <= height.length; i++) {
			int value=i==height.length?0:height[i];
			
			while (!stack.isEmpty() && stack.peek().value > value) {
				Node popNode = stack.pop();
				int index = stack.isEmpty()? i : i - stack.peek().index - 1;
				result = Math.max(result, popNode.value * index);
			}
			stack.push(new Node(i, value));
		}
		/*Node pop = stack.pop();
		int index = stack.isEmpty() ? height.length : pop.index - stack.peek().index;
		result = Math.max(result, pop.value * index);
*/
		
		return result;
	}

}
