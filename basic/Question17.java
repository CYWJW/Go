package com.wjw.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question17 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		List<Integer>sList=new ArrayList<>();
		List<Integer>nList=new ArrayList<>();
		//数字
		int n=scanner.nextInt();
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		
		for (int i = 0; i <n; i++) {
			int line = scanner.nextInt();
			sList.add(line);
		}
		nList=sList;
		Collections.sort(sList);
		if(a>b)
		{
			for (int i = 0; i <b; i++) {
				Integer integer = sList.get(i);
				for (Integer j : nList) {
					if(j==integer)
					{
						
					}
				}
			}
		}
		
		
	}
}