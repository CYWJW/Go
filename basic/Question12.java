package com.wjw.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Question12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//行数
		int row=scanner.nextInt();
		//列数
		int column=scanner.nextInt();
		int count=0;
		//行数
		for(int i=0;i<row;i++)
		{
			//列数
			for (int j = 0; j < column; j++) {
				//如果行数大于列数就是反的
				if(j<i)
				{
					//从多少开始
					int cout=65+i;
					//根据码表强转
					System.out.print((char)(cout-j));
				}
				else {
					//大于或等于 输出列减行+65
					System.out.print((char)(65+(j-i)));
				}
			}
			System.out.println();
			
		}
	
		
	}
}