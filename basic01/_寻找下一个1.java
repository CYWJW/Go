package com.wjw.basic02;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

public class _寻找下一个1 {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n = scanner.nextInt();
		int a[]=new int[n];
		for (int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			a[i]=value;
		}
		int[] reslut = f(a);
		for (int i = 0; i < n; i++) {
			int value=	reslut[i];
			System.out.print(value==-1?-1+" ":value+1 +" ");
		}
	}

	private static int[] f(int[] a) {
		if (a == null )
			return null;
		int result[]=new int[a.length];
		//栈
		LinkedList<LinkedList<Integer>> list = new LinkedList<>();
		for (int i = 0; i < a.length; i++) {
			while (!list.isEmpty() &&  a[list.getFirst().getFirst()] < a[i]) {
				LinkedList<Integer> pop = list.pop();
				for (Integer index:pop) {
					//自己的坐标 和别人的
					a[index]=i;
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
		while (!list.isEmpty()) {
			LinkedList<Integer> list2 = list.pop();
			for (Integer integer:list2) {
				a[integer]=-1;
			}
		}
		return a;
	}
}
