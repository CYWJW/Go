package com.wjw.paixun;

import java.util.Scanner;


public class GenderTree {
	static Scanner scanner = new Scanner(System.in);

	static class TreeNode {
		String num;
		// 左区间
		TreeNode lnode;
		// 右区间
		TreeNode rnode;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		preGenderTree(null,root);
		preNode(root);
	}

	static void preNode(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.num+" ");
		// 遍历左子树
		preNode(root.lnode);
		preNode(root.rnode);
	}

	// 参数当前节点  前序构建当前节点
	static void preGenderTree(TreeNode fa,TreeNode node) {
		System.out.println("请输入");
		// 建立左子树
		String value = scanner.nextLine();
		// 进行判断
		if (value.equals("#"))
		{
			if (fa.lnode==node) {
				fa.lnode=null;
			} else {
				fa.rnode=null;
			}
			return;
		}
		//传入当前值
		node.num=value;
		TreeNode lNode = new TreeNode();
		// 构建左子树
		node.lnode = lNode;
		preGenderTree(node,lNode);
		TreeNode rNode = new TreeNode();
		// 构建右子树
		node.rnode = rNode;
		preGenderTree(node,rNode);
	}

	
}
