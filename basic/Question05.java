package com.wjw.basic;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Question05 {
	static List<Integer> set=new LinkedList<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//和
		int count=scanner.nextInt();
		
		if(count%2==0)
		{
			
			addNumByFive(count);
			addNumBySix(count/2);
		}
		else {
			addNumByFive(count);
		}
		
		for(Integer num:set)
		{
			System.out.println(num);
		}
		
	}
	public static void addNumBySix(int num) {
		//生成六位数的回文数
		for(int i=1;i<=999;i++)
		{
			//取个位
			int g=i%10;
			//取十位
			int s=i/10%10;
			//取百位
			int b=i/100%10;
			int count=g+s+b;
			//如果加起来有一半
			if(count==num&&b!=0)
			{
				//001100 零也得加上  
				
				set.add(Integer.parseInt(""+b+s+g+g+s+b));
			}
		}
	}
	
	public static void addNumByFive(int num) {
		//生成五位数的回文数
		for(int i=0;i<=99;i++)
		{
			//取个位
			int g=i%10;
			//取十位
			int s=i/10%10;
			
			for(int l=0;l<10;l++)
			{
				//中间数
				int count=(g+s)*2+l;
				//如果减去第三位 再除2为cout则
				if(count==num)
				{
					set.add(Integer.parseInt(""+s+g+l+g+s));
				}
			}
			
		}
	}
}
