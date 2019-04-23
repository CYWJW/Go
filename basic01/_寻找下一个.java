package com.wjw.basic02;

import java.util.Scanner;
import java.util.TreeMap;

public class _寻找下一个 {
	public static void main(String[] args) {
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Scanner scanner=new Scanner(System.in);
		int n = scanner.nextInt();
		int a[]=new int[n];
		int max=0;
		for (int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			map.put(value, i);
			a[i]=value;
			max=Math.max(max, value);
		}
		a:for (int i = 0; i < a.length; i++) {
			int value=a[i];
			//找自己最大值
			while (value < max) {
				Integer key = map.higherKey(value);
				Integer index = map.get(key);
				if(i<index)
				{
					System.out.print(key+" ");
					continue a;
				}
				else {
					value=key;
				}
			}
			System.out.print(-1+" ");
			
		}
		
	}
	
}
