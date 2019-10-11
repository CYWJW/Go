package com.wjw.lintcode.middling;


public class _链表排序 {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static void main(String[] args) {
		ListNode head=new ListNode(2).next=new ListNode(1).next=new ListNode(3);
		while (head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
	}

	public static ListNode sortList(ListNode head) {
		// write your code here
		ListNode curNode=head;
		ListNode beg=head;
		ListNode end=head;
		while ((curNode= curNode.next)!=null) {
			if(curNode.val>=head.val) {
				//如果大于等于 挂在尾节点后
				end.next=curNode;
				end=end.next;
			}else {
				curNode.next=beg;
				beg=curNode;
			}
		}
		return beg;
	}

}
