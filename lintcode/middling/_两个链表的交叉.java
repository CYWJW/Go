package com.wjw.lintcode.middling;

public class _两个链表的交叉 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		ListNode headA=new ListNode(7);
		ListNode headB=new ListNode(6);
		headB.next=headA;
		getIntersectionNode(headA, headB);
		
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// write your code here
		if(headA==null || headB==null) {
			return null;
		}
		
		
		int stepA = 0;
		int stepB = 0;

		ListNode nodeA = headA;
		ListNode nodeB = headB;

		while (nodeA.next != null) {
			stepA++;
			nodeA = nodeA.next;
		}

		while (nodeB.next != null) {
			stepB++;
			nodeB = nodeB.next;
		}

		if (nodeA != nodeB) {
			return null;
		}

		ListNode longListHead = stepA > stepB ? headA : headB;
		ListNode shortListHead = stepA > stepB ? headB : headA;

		for (int i = 0; i < Math.abs(stepA - stepB); i++) {
			longListHead = longListHead.next;
		}

		while (longListHead!=shortListHead) {
			longListHead=longListHead.next;
			shortListHead=shortListHead.next;
		}
		return longListHead;
	}

}
