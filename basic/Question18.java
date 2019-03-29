package com.wjw.basic;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Question18 {
	static	LinkedList<Integer> list=new LinkedList();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int students=scanner.nextInt();
		int desk=scanner.nextInt();
		
		//记录淘气值
		for (int i = 0; i < students; i++) {
			list.add(scanner.nextInt());
		}
		Collections.sort(list);
		//一个人坐的
		int i = (desk<<1)-students;
		
		for (;i>0; i--) {
			list.removeLast();
		}
		
		int value=0;
		
		while (list.size()>0) {
			if(list.getFirst()+list.getLast()>value)
			{
				value=list.pop()+list.removeLast();
			}
			else {
				list.pop();list.removeLast();
			}
				
		}
		
		System.out.println(value);
		
	}
}
