package com.wjw.basic;

public class _年龄 {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++)
			for (int j = i; j < 100; j++) {
				if((i+j)*(j-i+1)==236<<1)
				{
					System.out.println(i+" "+j);
					break;
				}
			}
	}
}
