package com.wjw.basic01;

public class MorrisToList {
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
		morris();
		while (root!=null) {
			System.out.print(root.value+" ");
			root=root.right;
		}
	}

	private static void morris() {
		Node cur = root;
		Node maxRight = null;
		while (cur != null) {
			maxRight = cur.left;
			if (maxRight != null) {
				while (maxRight.right != null && maxRight.right != cur)
					maxRight = maxRight.right;
				if (maxRight.right == null) {
					maxRight.right = cur;
					cur = cur.left;
					continue;
				} else
				{
					Node rootNode=cur.right;
					//当前右节点为上一个节点的右节点
					maxRight.right = cur.right;
					//交换
					cur.right=cur.left;
					cur.left=null;
					cur=rootNode;
					continue;
				}
					
			}
			cur = cur.right;
		}
	}

}
