package com.wjw.Introduction;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Question02 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//int r=scanner.nextInt();
		
		
	//	double s=Math.PI*r*r;
		DecimalFormat decimalFormat=new DecimalFormat("#.000");
		/*//获取转换实列
		  NumberFormat nf= NumberFormat.getNumberInstance();
		  //设置保留位数
		  nf.setMaximumFractionDigits(8);
		  nf.setGroupingUsed(false);
		  //设置四舍五入
		  nf.setRoundingMode(RoundingMode.UP);
		  System.out.println(nf.format(s));*/
		  System.out.println(decimalFormat.format(5.5561));
	}
}
