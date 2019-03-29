package com.wjw.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Question19 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//宽
		int x=scanner.nextInt();
		//长
		int y=scanner.nextInt();
		//星星数量
		int n=scanner.nextInt();
		
		int array[][]=new int[x][y];
	
		Map<Integer, Integer> map=new HashMap<>();
		
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				array[i][j]=scanner.nextInt();
		
		
		//第二行开始
		for (int i = 1; i < x; i++)
		{
			//二个数开始
			for (int j = 1; j < y; j++)
			{
				if(array[i][j]==1)
				{
					try {
						if (array[i+1][j]==1 && array[i-1][j]==1) 
						{
							if (array[i][j+1]==1 && array[i][j-1]==1) 
							{
								map.put(i, j);
							}
						}
						
					} catch (Exception e) {
					}
				}
			}
		}
		
	}
}
