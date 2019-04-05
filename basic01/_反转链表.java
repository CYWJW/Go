package com.wjw.basic01;

public class _反转链表 {
	static Node init()
	{
		Node head = new Node(1);
		Node node01 = new Node(2);
		Node node02 = new Node(3);
		Node node03 = new Node(4);
		Node node04 = new Node(5);
		Node node05 = new Node(6);

		head.next=node01;
		node01.next=node02;
		node02.next=node03;
		node03.next=node04;
		node04.next=node05;
		
		return head;
	}
	static class Node
	{
		int value;
		Node next;
		public Node(int value) {
			super();
			this.value = value;
		}
		
	}
	public static void main(String[] args) {
		Node node = init();

		node=ReversalLinked(node);
		while (node!=null) {
			System.out.print(node.value+" ");
			node=node.next;
		}
	}
	static Node ReversalLinked(Node node) {
		//反转链表
		Node perNode=null;
		Node nextNode=null;
		Node newNode=null;
		while(node!=null)
		{
			//记录下一个链表
			nextNode = node.next;
			if(node.next==null)
				newNode=node;
			//指向上一个
			node.next=perNode;
			perNode=node;
			//当前链表头
			node=nextNode;
		}
		return newNode;
	}
}
