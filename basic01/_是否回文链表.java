package com.wjw.basic01;

public class _是否回文链表 {
	static Node init() {
		Node head = new Node(1);
		Node node01 = new Node(2);
		Node node02 = new Node(3);
		Node node03 = new Node(3);
		Node node04 = new Node(2);
		Node node05 = new Node(1);
		head.next = node01;
		node01.next = node02;
		node02.next = node03;
		node03.next = node04;
		node04.next=node05;
		return head;
	}

	static class Node {
		int value;
		Node next;

		public Node(int value) {
			super();
			this.value = value;
		}

	}

	public static void main(String[] args) {
		Node node = init();
		System.out.println(PalindLinked(node));
		while (node!=null) {
			System.out.print(node.value+" ");
			node=node.next;
		}
	}

	static boolean PalindLinked(Node node) {
		// 快指针
		Node k = node;
		// 慢指针
		Node m = node;
		// 到快指针不为空
		while (k.next != null && k.next.next != null) {
			k = k.next.next;
			m = m.next;
		}
		k = node;
		// 反转链表
		Node newHead = ReversalLinked(m.next, null);
		Node newNode = newHead;
		// 进行判断
		while (newNode.next != null) {
			if (k.value != newNode.value) {
				// 反转回来
				ReversalLinked(newHead, null);
				return false;
			}
			k = k.next;
			newNode = newNode.next;
		}
		ReversalLinked(newHead, null);
		return true;
	}

	private static Node ReversalLinked(Node node, Node perNode) {
		Node newHead = null;
		Node nextNode = null;
		while (node != null) {
			// 记录下一个
			nextNode = node.next;
			// 记录头
			if (node.next == null) {
				newHead = node;
			}
			// 反转
			node.next = perNode;
			perNode = node;
			node = nextNode;
		}
		return newHead;
	}
}
