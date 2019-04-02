package com.wjw.basic01;

class Node{
	Node left;
	Node right;
	int value;
	public Node(int value) {
		this.value = value;
	}
}

public class _树的反序列化 {
	static	int n=0;
	public static void main(String[] args) {
		String nodes="1_2_4_#_#_#_3_#_#_";
		String[] split = nodes.split("_");
		//初始化
		Node node = perTree(split);
		perTree(node);
	}
	private static void perTree(Node nodes) {
		if(nodes!=null)
		{
			System.out.println(nodes.value);
			perTree(nodes.left);
			perTree(nodes.right);
		}
		
		
	}
	
	private static Node perTree(String[] nodes) {
		if(nodes.length<1) return null;
		//当前的节点创建
		Node newNode=new Node(Integer.parseInt(nodes[n]));
		String left = nodes[++n];
		if(!left.equals("#"))
		{
			//创建左子树
			newNode.left=perTree(nodes);
		}
		String right = nodes[++n];
		if(!right.equals("#"))
		{
			//创建右子树
			newNode.right=perTree(nodes);
		}
		return newNode;
	}
	
}
