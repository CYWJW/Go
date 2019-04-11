package com.wjw.basic01;

import java.util.LinkedList;
import java.util.List;

/**
 * 找寻一段数字连续中的最小数 o(n)
 * 
 * @author 汪军伍
 */
class node
{
	int i;
	Integer rmax;
	Integer lmax;
	public node(int rmax) {
		this.rmax = rmax;
	}
}

public class _左右最近最大值 {
	public static void main(String[] args) {
		int a[] = { 1, 5, 8, 6, 2, 6, 7, 2, 6, 8 };
		
		
		List<node> vue = f(a);
		
		for(node node:vue)
		{
			System.out.println("下标是" +node.i+" "+node.lmax+" " + node.rmax);
		}
	}

	private static List<node> f(int[] a) {
		if (a == null )
			return null;
		//存最大小值
		 List<node> rt = new LinkedList<>();
		//栈
		LinkedList<LinkedList<Integer>> list = new LinkedList<>();
		
		for (int i = 0; i < a.length; i++) {
			while (!list.isEmpty() &&  a[list.getFirst().getFirst()] < a[i]) {
				LinkedList<Integer> pop = list.pop();
				for (Integer index:pop) {
					//出现大的值
					node node = new node(a[i]);
					node.i=index;
					//出栈
					if(!list.isEmpty())
						//如果队列不为空 那么就是自己的下一个
						node.lmax=a[list.getFirst().getFirst()];
					rt.add(node);
				}
				
			}
			//判断是否是相等 不相等创建
			if(!list.isEmpty() && a[list.getFirst().getFirst()]==a[i])
			{
				list.getFirst().add(i);
			}
			else {
				LinkedList<Integer> linkedList = new LinkedList<>();
				linkedList.add(i);
				list.push(linkedList);
			}
			
		}
		return rt;
	}
}
