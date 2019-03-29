package com.wjw.Introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question01 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		List<Integer>list=new ArrayList<>();
		//第一项
		int a=1;
		//第二项
		int b=1;
		for(int i=0;i<num/2+1;i++)
		{
			list.add(a);
			list.add(b);
			//第奇数项 为上一次的奇数+偶数
			a=(a+b)%10007;
			//第偶数项现在的奇数项+上次的偶数项
			b=(b+a)%10007;
		}
		System.out.println(list.get(num-1)%10007);
	}
	
	
}
