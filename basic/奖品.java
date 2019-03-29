package com.wjw.basic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 奖品 {
	static LinkedList<LinkedList<Integer>> list = new LinkedList<>();

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	//样列
	int nextInt = scanner.nextInt();
	for (int i = 0; i < nextInt; i++) {
		LinkedList<Integer> list2 = new LinkedList<>();
		int k = scanner.nextInt();
		for (int j = 0; j < k; j++) {
			list2.add(scanner.nextInt());
		}
		list.add(list2);
	}
	
	for (int i = 0; i < list.size(); i++) {
		int num=1;
		int size=1;
		LinkedList<Integer> linkedList = list.get(i);
		Collections.sort(linkedList);
		for (int j = 1; j < linkedList.size()-1; j++) {
			//如果后面和前面相等
			if (linkedList.get(j-1)==linkedList.get(j)) {
				//变回来
				size=1;
				//步长不变
				num=num+size;
			}
			
			//如果后面比前面小
			if (linkedList.get(j-1)<linkedList.get(j)) {
				//步长+1
				size++;
				num=num+size;
			}
		}
		
		if (linkedList.getLast()>linkedList.getFirst()) {
			num++;
			
		}
		System.out.println(num);
	}
	}

	
	}
