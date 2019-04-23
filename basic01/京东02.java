package com.wjw.basic02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 京东02 {
	
	static class node implements Comparable<node>{
		int index;
		int max;
		String str;
		
		public node(int max, String str,int index) {
			this.max = max;
			this.str = str;
			this.index=index;
		}

		@Override
		public int compareTo(node o) {
			return o.max-this.max;
		}

		@Override
		public String toString() {
			return "node [index=" + index + ", max=" + max + ", str=" + str + "]";
		}
		
	}

	static List<node> list=new LinkedList<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		String str[] = new String[m];
		scanner.nextLine();
		for (int i = 0; i < m; i++) {
			str[i] = scanner.nextLine();
		}
		
		String strT = scanner.nextLine();
		for (int i = 0; i < m; i++) {
			getMaxSameStr(str[i], strT,i);
		}
	
		int cout=0;
		List<String> sList=new ArrayList<>();
		sList.add(strT);
		int is[]=new int[m];
		//找到余下的
		for (int i = 0; i < m-1; i++) {
			//排序
			Collections.sort(list);
			//结论
			cout+=Chong(list.get(0).str);
			//找到最多切割
			getMaxLists(sList,list.get(0).str);
			is[list.get(0).index]=1;
			list.clear();
			for(String string:sList)
			for (int j = 0; j < m; j++) {
				//如果没被使用过
				if(is[j]!=1)
				{
					getMaxSameStr(str[j], string,i);
				}
			}
		}
		
		
		System.out.println(cout);
		
		
	}
	
	private static void getMaxLists(List<String> sList, String str) {
		for (int i = 0; i < sList.size(); i++) {
			//找到可以切割
			String string = sList.get(i);
			if(string.contains(str))
			{
				//移除
				sList.remove(i);
				String[] split = string.split(str);
				for (int j = 0; j < split.length; j++) {
					sList.add(split[j]);
				}
				break;
			}
		}
		
	}

	private static int Chong(String str)
	{
		Set<String> set=new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				set.add(str.substring(i, j+1));
			}
		}
		return set.size();
	}
	
	private static void getMaxSameStr(String str1, String str2,int index) {
		int len1 = str1.length();
		int len2 = str2.length();
		// 定义一个二维辅助空间
		int str[][] = new int[len1][len2];
		int max = 1;
		int x = 0;
		// 进行遍历
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				// 处理初始化边界
				if (i == 0 || j == 0) {
					if (str1.charAt(i) == str2.charAt(j))
						str[i][j] = 1;
				}
				// 为上一个储存的i j +1
				else if (str1.charAt(i) == str2.charAt(j)) {
					str[i][j] = str[i - 1][j - 1] + 1;
					if (str[i][j] > max) {
						max = str[i][j];
						// 保存最后一位的数
						x = i;
					}
				}
			}
		}
		list.add(new node(max,str1.substring(x - max  + 1, x+1), index));
		/*for (int i = 0; i < max; i++) {
			// 找到第一位
			System.out.print(str1.charAt(x - max + i + 1));
		}*/
	}

}
