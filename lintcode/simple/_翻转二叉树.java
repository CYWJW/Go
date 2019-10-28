package com.wjw.lintcode.simple;

import java.util.LinkedList;

import com.wjw.lintcode.simple._翻转二叉树.TreeNode;

import sun.misc.Queue;

public class _翻转二叉树 {
	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	/*public void invertBinaryTree(TreeNode root) {
		// write your code here
		if(root== null) {
			return;
		}
		
		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
		
		TreeNode left = root.left;
		root.left=root.right;
		root.right=left;
	}*/
	
	
	public void invertBinaryTree(TreeNode root) {
		// write your code here
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.removeFirst();
			TreeNode left = treeNode.left;
			treeNode.left=treeNode.right;
			treeNode.right=left;
			
			if(left!=null) {
				queue.add(left);
			}
			
			if(treeNode.left!=null) {
				queue.add(treeNode.left);
			}
		}
	}
}
