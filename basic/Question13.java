package com.wjw.basic;



public class Question13 {
	public static void main(String[] args) {
		//此把十进制转为二进制可解
		
		
		for(int i=0;i<32;i++)
		{
			String result=Integer.toBinaryString(i);
			//如果缺少5位的补全
			String bu="";
			for(int g =0 ; g<(5-result.length());g++)
			{
				bu+="0";
			}
			System.out.println(bu+result);
		}
	}
}