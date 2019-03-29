package com.wjw.qus;

import java.util.LinkedList;
import java.util.List;


public class MinTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val ;
		}
		
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(6);
		root.right = new TreeNode(14);

		root.left.left = new TreeNode(12);
		root.right.right = new TreeNode(16);
		root.right.right.right = new TreeNode(20);
		int num = run(root);
		int num01 = run01(root);
		System.out.println(num);
		System.out.println(num01);
	}

	private static int run01(TreeNode root) {
		if (root == null)
			return 0;
		// 非递归 层序遍历
		LinkedList<TreeNode> list = new LinkedList<>();
		LinkedList<TreeNode> newList = new LinkedList<>();
		list.add(root);
		int num = 0;
		// 不为空
		while (true) {
			TreeNode node = list.pop();
			if (node.left != null) {
				// 左入队列
				newList.addLast(node.left);
			}
			if (node.right != null) {
				// 右入队列
				newList.addLast(node.right);
			}
			if (node.left == null && node.right == null) {
				num++;
				break;

			}

			// 如果此层遍历完
			if (list.isEmpty()) {
				list.clear();
				list.addAll(newList);
				newList.clear();
				num++;
			}

		}
		return num;
	}

	// 返回每次最小即可 递归

	public static int run(TreeNode root) {
		int leftnum = Integer.MAX_VALUE;
		int rigtnum = Integer.MAX_VALUE; // 为空不进去
		if (root.left != null) {
			leftnum = run(root.left);
		} // 为空不进去
		if (root.right != null) {
			rigtnum = run(root.right);
		}

		// 找到叶子节点
		else if (root.left == null && root.right == null) {
			return 1;
		}
		return Math.min(leftnum, rigtnum) + 1;
	}

}
