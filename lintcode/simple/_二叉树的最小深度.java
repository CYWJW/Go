package com.wjw.lintcode.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.wjw.basic03.Code_01_Building_Outline.Node;

public class _二叉树的最小深度 {
	
	 public static class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	
	public int minDepth(TreeNode root) {
        // write your code here
		if(root == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList();
		HashMap<TreeNode,Integer> map = new HashMap<>();
		queue.add(root);
		map.put(root, 1);
		TreeNode cur=null;
		while (true) {
			cur=queue.removeFirst();
			TreeNode left=cur.left;
			TreeNode right=cur.right;
			
			if(left==null && right==null) {
				return map.get(cur);
			}
			
			if(left!=null) {
				queue.add(left);
				map.put(left, map.get(cur)+1);
			}
			
			if(right!=null) {
				queue.add(right);
				map.put(right, map.get(cur)+1);
			}
		}
    }
}
