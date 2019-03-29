package com.wjw.basic;

import java.util.Map;
import java.util.Scanner;

public class BASIC_24
{
	static int v1,v2,t,s,l;
	public static void main(String args[])
	{
		Scanner scanner=new Scanner(System.in);
		//兔子
		v1=scanner.nextInt();
		v2=scanner.nextInt();
		//领先的米
		t=scanner.nextInt();
		//休息的秒
		s=scanner.nextInt();
		//长度
		l=scanner.nextInt();
	
		//记录秒数
		int count=0;
		//兔子米数
		int runT=0;
		//乌龟米数
		int runW=0;
		
		boolean flag=false;
		int time=0;
		while (true) {
			count++;
			//如果兔子比乌龟领先 就休息
			if((runT-runW)>=t)
			{
				flag=true;
			}
			
			if(flag==true)
			{
				time++;
			}
			
			if(time>s||time==0)
			{
				runT+=v1;
				//重新计时
				time=0;
				flag=false;
			}
			runW+=v2;
			if(runT==l||runW==l)
			{
				break;
			}
		}
		
		//根据米数设置
		if(runT>runW)
		{
			System.out.println("R");
			System.out.println(count++);
			
		}
		else	if(runT<runW)
		{
			System.out.println("T");
			System.out.println(count++);
			
		}
		else {
			System.out.println("D");
			System.out.println(count++);
			
		}
	}
}
