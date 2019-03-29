package com.wjw.basic;

import java.util.Scanner;
/**
 * 
 * @author 汪军伍
 * 关键 好芯片的1一定是大于或等于0的 坏芯片一定是0大于1的
 */
public class BASIC_23
{
	static int num;
	static int test[][];
	static int ifTrue[];
	
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		//获取矩阵
		num=scanner.nextInt();
		test=new int[num][num];
		 ifTrue=new int[num];
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++)
			{
				test[i][j]=scanner.nextInt();
			}
		}
		
		
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++)
			{
				//如果出了本身判断为一 那就判断哪个芯片
				if(test[i][j]==1&&i!=j)
				{
					ifTrue[j]++;
				}
				
				//如果出了本身判断为一 那就判断哪个芯片
				else if(test[i][j]!=1&&i!=j)
				{
					ifTrue[j]--;
				}
				
			}
		}
		
		for(int i=0;i<ifTrue.length;i++)
		{
			if(ifTrue[i]>=0)
				System.out.print(" "+(i+1));
		}
		
	}
	//AB AC AB AD AB AC AB    A
	//            AB AC AB    A
	//                  AB    A
	//                        A
}
