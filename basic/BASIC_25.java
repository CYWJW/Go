package com.wjw.basic;

import java.util.Scanner;

public class BASIC_25

{
	// 定义数组
	static int array[][];
	static int height;
	static int width;
	static int x;
	static int y;
	static int z;
	static int w;
	static int round;
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		height = scanner.nextInt();
		width = scanner.nextInt();
		array = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
	
		w=width-1;
		y=height-1;
		//取最大的 循环
		for(int i=0;i<(Math.min(height, width)/2+1);i++)
		{
			h_l(x);
			l_r(y);
			l_h(w);
			r_l(z);
			round++;
		}
	}

	// 列从上到下 l为列
	public static void h_l(int l) {
		for (int i = 0+round; i < height-round; i++) {
			//如果为-1就不输出
			int reslut=array[i][l];
			if(reslut!=-1)
			{
				System.out.print(" "+reslut);
				//输出的变为-1
				array[i][l]=-1;
			}
		}
		//列增加一
		x++;
	}
	
	// 列从下到上 l为列
	public static void l_h(int l) {
		for (int i = height-1-round; i >-1+round ; i--) {
			//如果为-1就不输出
			int reslut=array[i][l];
			if(reslut!=-1)
			{
				System.out.print(" "+reslut);
				//输出的变为-1
				array[i][l]=-1;
			}
		}
		w--;
	}
	
	// 列从右到左  row为行
	public static void r_l(int row) {
		for (int i = width-1-round; i >-1+round ; i--) {
			//如果为-1就不输出
			int reslut=array[row][i];
			if(reslut!=-1)
			{
				System.out.print(" "+reslut);
				//输出的变为-1
				array[row][i]=-1;
			}
		}
		z++;
	}
	
	// 列从右到左 row为行
	public static void l_r(int row) {
		
		for (int i = 0+round; i <width-round ; i++) {
			//如果为-1就不输出
			int reslut=array[row][i];
			if(reslut!=-1)
			{
				System.out.print(" "+reslut);
				//输出的变为-1
				array[row][i]=-1;
			}
		}
		//行-1
		y--;
	}
	
}
