package com.wjw.lintcode.difficulty;

import java.util.Stack;

import com.wjw.lintcode.difficulty._区间求和II.Node;

public class _区间求和II {

	int[] A;
	Node root;

	class Node {
		Node left;
		Node right;
		int start;
		int end;
		long sum;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		_区间求和II A = new _区间求和II(new int[] { 1, 1, 8, 5 });
		System.out.println(A.query(0, 2));
		A.modify(0, 3);
		System.out.println(A.query(2, 3));
	}

	public _区间求和II(int[] A) {
		this.A = A;
		if (this.A != null && this.A.length > 0) {
			root = init(0, A.length - 1);
		}
	}

	Node init(int start, int end) {
		Node node = new Node(start, end);
		if (start == end) {
			node.sum = A[start];
			return node;
		}

		node.left = init(start, (start + end) / 2);
		node.right = init((start + end) / 2 + 1, end);
		node.sum = node.left.sum + node.right.sum;
		return node;
	}

	public long query(int start, int end) {
		Node cur = root;
		// 找到刚好包含的根节点
		while (cur.left != null && cur.right != null) {
			if (cur.left.start <= start && cur.left.end >= end) {
				cur = cur.left;
				continue;
			}

			if (cur.right.start <= start && cur.right.end >= end) {
				cur = cur.right;
				continue;
			}
			break;
		}

		if (cur.start == start && cur.end == end) {
			return cur.sum;
		}

		long leftSum = 0;
		if (cur.left.start == start && cur.left.end <= end) {
			leftSum = cur.left.sum;
		} else {
			Node bef = root;
			root = cur;
			leftSum = query(start, cur.left.end);
			root = bef;
		}
		long rightSum = 0;
		if (cur.right.start >= start && cur.right.end == end) {
			rightSum = cur.right.sum;
		} else {
			Node bef = root;
			root = cur;
			rightSum = query(cur.right.start, end);
			root = bef;
		}

		return leftSum + rightSum;
	}

	public void modify(int index, int value) {
		// write your code here

		Stack<Node> stack = new Stack<>();
		Node cur = root;
		while (true) {
			if (cur.end == cur.start) {
				cur.sum = value;
				break;
			}

			stack.push(cur);
			if (cur.left.start <= index && cur.left.end >= index) {
				cur = cur.left;

			} else {
				cur = cur.right;
			}
		}

		while (!stack.isEmpty()) {
			Node node = stack.pop();
			node.sum = node.left.sum + node.right.sum;
		}
	}

}
