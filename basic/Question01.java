package com.wjw.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Question01 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		List<Integer>list=new ArrayList<>();
		
		for(int i=0;i<num;i++)
		{
			list.add(scanner.nextInt());
		}
		//排序
		Collections.sort(list);
		
		for(Integer i:list)
		{
			System.out.print(i+" ");
		}
	}
	
	
}
