package com.wjw.lintcode.difficulty;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageTypeSpecifier;

public class _统计前面比自己小的数的个数 {

	static class Tree {
		int start;
		int end;
		int count;
		Tree left;
		Tree right;

		public Tree(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public List<Integer> countOfSmallerNumberII(int[] A) {
		// write your code here
		List<Integer> result = new ArrayList<>(A.length);
		Tree root = initTree(0, 10000);
		for (int num : A) {
			int count = 0;
			build(root, num);
			if (num != 0) {
				count = searchNum(root, num - 1);
			}

			result.add(count);
		}

		return result;
	}

	private void build(Tree root, int num) {
		// TODO Auto-generated method stub
		if (root.start == root.end) {
			root.count++;
			return;
		}
		root.count++;
		if (root.left.end >= num) {
			build(root.left, num);
		}
		if (root.right.start <= num) {
			build(root.right, num);
		}
	}

	private int searchNum(Tree root, int num) {
		if (root.start == root.end) {
			return root.count;
		}
		// 如果左边是等于 直接返回结果
		if (root.left.end == num) {
			return root.left.count;
		}
		int leftNum = 0;
		// 如果左边得最大还是小于则 返回
		if (root.left.end < num) {
			leftNum = root.left.count;
		}
		int rightNum = 0;
		if (root.right.start <= num) {
			rightNum = searchNum(root.right, num);
		}
		// 如果没有得不出结果直接继续
		if (root.left.end > num) {
			return searchNum(root.left, num);
		}
		return leftNum + rightNum;
	}

	private Tree initTree(int start, int end) {
		// TODO Auto-generated method stub
		if (start == end) {
			return new Tree(start, end);
		}
		Tree node = new Tree(start, end);
		node.left = initTree(start, (start + end) / 2);
		node.right = initTree((start + end) / 2 + 1, end);
		return node;
	}
}
