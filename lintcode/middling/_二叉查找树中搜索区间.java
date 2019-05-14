package com.wjw.lintcode.middling;

import java.util.ArrayList;
import java.util.List;

public class _二叉查找树中搜索区间 {

	public static class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	public static void main(String[] args) {
		
	}
	
	public List<Integer> searchRange(TreeNode root, int k1, int k2) {
		 List<Integer> list = new ArrayList<>();
		 if(root==null) return list; 
		 midList(root,list,k1,k2);
		 
		 return list;
    }

	private void midList(TreeNode root, List<Integer> list, int k1, int k2) {
		if(root == null ) return;
		midList(root.left,list,k1,k2);
		if(root.val>=k1 && root.val<=k2)
			list.add(root.val);
		midList(root.right,list,k1,k2);
	}
}
