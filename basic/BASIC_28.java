package com.wjw.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BASIC_28 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		List<Integer>list=new ArrayList<>();
		//输入的数
		int number=scanner.nextInt();
		for(int i=0;i<number;i++)
		{
			//加入集合的数
			list.add(scanner.nextInt());
		}
		int count=0;
		//进行哈夫曼编码 需要n-1次
		for (int i=0;i<number-1;i++) {
			//进行排序
			Collections.sort(list);
			//取最小的两个值
			int min01=list.get(0);
			int min02=list.get(1);
			//计算值加入集合
			int newNum=min01+min02;
			//计算和添加
			list.add(newNum);
			//连续移除首位
			list.remove(0);
			list.remove(0);
			//计算总值
			count+=newNum;
		}

		//输出
		System.out.println(count);
	}
}
