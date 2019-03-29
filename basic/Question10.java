package com.wjw.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Question10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//循环的次数
		int num=scanner.nextInt();
		List<Integer>list=new ArrayList<>();
		for(int i=0;i<num;i++)
		{
			list.add(scanner.nextInt());
		}
		//读取查找的树
		Integer a=scanner.nextInt();
		
		for (int i = 0; i < num; i++) {
			if(a==list.get(i))
			{
				System.out.println(i+1);
				break;
			}
			//如果到了最后一个没有的话
			if(i==num-1)
			{
				System.out.println(-1);
			}
		}
		
		
	}
}