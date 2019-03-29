package com.wjw.basic;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 去字母 {
	static LinkedList<String> list = new LinkedList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 行
		int n = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i <n; i++)
			list.add(scanner.nextLine());

		for (int i = list.size() - 1; i > -1; i--) {
			String string = list.removeFirst();
			String newString = validate(string);
			String string2 = validate01(newString);
			System.out.println(string2);
		}

	}

	private static String validate01(String string) {
		String newString=string;
		for (int i = 0; i < string.length()-3; i++) {
			if(string.charAt(i)==string.charAt(i+1) && string.charAt(i+2)==string.charAt(i+3))
			{
				newString=string.substring(0, i+2)+string.substring(i+3,string.length());
				i--;
				string=newString;
			}
		}
		return newString;
	}
	
	private static String validate(String string) {
		String newString=string;
		//第一个规则
		for (int i = 0; i < string.length()-2; i++) {
				if(string.charAt(i)==string.charAt(i+1) && string.charAt(i+1)==string.charAt(i+2))
				{
					newString=string.substring(0, i)+string.substring(i+1, string.length());
					i--;
					string=newString;
				}
				
			}
		return newString;
		}
	
	}
