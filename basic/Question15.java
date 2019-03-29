package com.wjw.basic;

import java.util.Scanner;

public class Question15 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int year=scanner.nextInt();
		//判断是否闰年
		if(year%4==0&&year%100!=0)
		{
				System.out.println("yes");
			return;
		}
		else if(year%400==0)
		{
			System.out.println("yes");
			return;
		}
		System.out.println("no");
		
	}
}