package com.wjw.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question09 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Long>list=new ArrayList<>();
		// 和
		int rows = scanner.nextInt();
		// 输出第一行
		System.out.println(1);
		// 输出第二行
		System.out.println(1 + " " + 1);
		list.add((long) 1);
		list.add((long) 1);
		// 从第三行开始
		for (int i = 3; i <= rows; i++) {
			list=getList(list);
			System.out.println(list);
		}
	}
	public static List<Long> getList(List<Long> list)
	{
		List<Long>list2=new ArrayList<>();
		//添加第一个
		list2.add((long) 1);
		for(int i =1;i<list.size();i++)
		{
			list2.add(list.get(i)+list.get(i-1));
		}
		//添加最后个
		list2.add((long) 1);
		return list2;
	}
}
