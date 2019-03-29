package com.wjw.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Question11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//循环的次数
		int num=scanner.nextInt();
		List<Integer>list=new ArrayList<>();
		int count=0;
		for(int i=0;i<num;i++)
		{
			int a=	scanner.nextInt();
			count+=a;
			list.add(a);
		}
		Collections.sort(list);
		//最大值
		//System.out.println(Collections.max(list));
		System.out.println(list.get(num-1));
		//最小值
		//System.out.println(Collections.min(list));
		System.out.println(list.get(0));
		//和
		System.out.println(count);
		
	}
}