package com.wjw.basic;

import java.util.Scanner;

public class Question08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//和
		int rows=scanner.nextInt();

        for(int i =0;i<rows;i++) {
            long number = 1;
            for(int j=0;j<=i;j++) {
                 System.out.print(number+" ");
                 //i是行数 从零开始  j是列数从零开始 当前列数再减一
                 number = number * (i - j) / (j + 1);          
            }
            System.out.println();
        }
    }

}
