package com.wjw.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question16 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		LinkedList<String> list=new LinkedList<>();
		List<String>sList=new ArrayList<>();
		int n=scanner.nextInt();
		for (int i = 0; i <=n; i++) {
			String line = scanner.nextLine();
			sList.add(line);
		}

		for (String str:sList) {
			//分解
			String[] split = str.split(" ");
			if(split.length==1)
			{
				if(split[0].equals("query"))
				{
					System.out.println(list.get(0));
				}
				else if(split[0].equals("pop"))
				{
					list.pop();
				}
			}
			else {
				if(split[0].equals("push"))
				{
					list.push(split[1]);
				}
				else if (split[0].equals("delete") ){
					list.remove(split[1]);
				}
			}
		}
		
	}
}