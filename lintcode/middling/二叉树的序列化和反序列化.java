package com.wjw.lintcode.middling;

public class 二叉树的序列化和反序列化 {
	public static class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	// 构建一颗 3的二叉树
	static TreeNode root;
	static {
		// 构建一颗 3的二叉树
		root = new TreeNode(0);
		TreeNode rootLeft = new TreeNode(1);
		TreeNode rootright = new TreeNode(2);
		// 左边左右节点
		TreeNode threeLeft01 = new TreeNode(3);
		TreeNode threeright01 = new TreeNode(4);
		// 右边左右节点
		TreeNode threeLeft02 = new TreeNode(5);
		TreeNode threeright02 = new TreeNode(6);
		root.left = rootLeft;
		root.right = rootright;
		rootLeft.left = threeLeft01;
		rootLeft.right = threeright01;
		rootright.left = threeLeft02;
		rootright.right = threeright02;
	}

	public static String serialize(TreeNode root) {
		String serStr = "";
		TreeNode cur = root;
		TreeNode maxRight = null;
		while (cur != null) {
			maxRight = cur.left;
			// 如果左子树不为空
			if (maxRight != null) {
				while (maxRight.right != null && maxRight.right != cur) {
					maxRight = maxRight.right;
				}
				if (maxRight.right == null) {
					serStr += cur.val + ",";
					maxRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					maxRight.right = null;
					serStr+="#" + ",";
				}
			} else {
				serStr += cur.val + "," + "#" + ",";
			}
			cur = cur.right;
		}

		return "{" + serStr + "#}";
	}

	public static void main(String[] args) {
		String serialize = serialize(root);
		deserialize(serialize);
		System.out.println(serialize);
	}

	public static TreeNode deserialize(String data) {
		data = data.substring(1, data.length() - 1);
		String[] deser = data.split(",");
		TreeNode root = null;
		if (deser.length > 1) {
			 root = new TreeNode(Integer.valueOf(deser[0]));
			dePer(root, deser);
		}
		return  root;
	}

	static int i = 1;

	private static void dePer(TreeNode node, String[] data) {
		String va = data[i++];
		if (!va.equals("#")) {
			TreeNode left = new TreeNode(Integer.valueOf(va));
			node.left = left;
			dePer(left, data);
		}
		 va = data[i++];
		if (!va.equals("#")) {
			TreeNode right = new TreeNode(Integer.valueOf(va));
			node.right = right;
			dePer(right, data);
		}
	}
}
