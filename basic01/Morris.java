package com.wjw.basic01;

import javax.print.attribute.standard.MediaSize.NA;

public class Morris {
	// 节点信息
	static class Node {
		public Node(int value) {
			this.value = value;
		}

		boolean flag = false;
		// 左节点
		Node left;
		// 又节点
		Node right;

		int value;
	}

	// 构建一颗 3的二叉树
	static Node root;
	static {
		// 构建一颗 3的二叉树
		root = new Node(0);
		Node rootLeft = new Node(1);
		Node rootright = new Node(2);
		// 左边左右节点
		Node threeLeft01 = new Node(3);
		Node threeright01 = new Node(4);
		// 右边左右节点
		Node threeLeft02 = new Node(5);
		Node threeright02 = new Node(6);
		root.left = rootLeft;
		root.right = rootright;
		rootLeft.left = threeLeft01;
		rootLeft.right = threeright01;
		rootright.left = threeLeft02;
		rootright.right = threeright02;
	}

	public static void main(String[] args) {
		aftMorris();
	}

	private static void aftMorris() {
		Node cur = root;
		Node maxRight = null;
		while (cur != null) {
			maxRight = cur.left;
			// 如果左子树不为空
			if (maxRight != null) {
				while (maxRight.right != null && maxRight.right != cur) {
					maxRight = maxRight.right;
				}
				if (maxRight.right == null) {
					maxRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					maxRight.right = null;
					printRight(cur.left);
				}
			}
			cur = cur.right;
		}
		printRight(root);
	}

	private static void printRight(Node left) {
		Node node = left;

		for (int i = 0; i < 2; i++) {
			Node fa = null;
			// 逆转右子树
			while (node != null) {
				if (i == 1)
					System.out.print(node.value+" ");
				// 保存当前节点下一个
				Node cNode = node.right;
				node.right = fa;
				// 当前节点作为父节点
				fa = node;
				// 下个节点作为当前节点
				node = cNode;
			}
			node = fa;
		}

	}

	private static void morris() {
		// 定义两个指针
		Node cur = root;
		Node maxRight = null;

		// 如果根节点不为空
		while (cur != null) {
			// 找到左节点
			maxRight = cur.left;

			// 如果左节点不为空
			if (maxRight != null) {
				// 遍历到左的最右节点
				while (maxRight.right != null && maxRight.right != cur) {
					maxRight = maxRight.right;
				}
				// 如果右节点为空 为第一次来
				if (maxRight.right == null) {
					System.out.print(cur.value + " ");
					// 指向上一层
					maxRight.right = cur;
					// cur左移
					cur = cur.left;
					continue;
				} else {
					// 如果是第二次来
					maxRight.right = null;
				}
			} else
				System.out.print(cur.value + " ");
			cur = cur.right;
		}

	}

}
