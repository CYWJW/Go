package com.wjw.basic02;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class _平行线 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			a[i][0] = scanner.nextInt();
			a[i][1] = scanner.nextInt();
		}
		if (n == 3 || n == 2) {
			System.out.println(0);
			return;
		}
		//存放走过的点
		boolean is[]=new boolean[n];
		boolean flag=true;
		int sum=0;
		while (flag) {
			 int i = f(a, is);
			 flag= i==0?false:true;
			 sum+=i;
		}
		System.out.println(sum);
	}
	
	static int f(int a[][],boolean is[]) {
		//存放斜率
		HashMap<String, Integer> map = new HashMap<>();
		//存放斜率的点
		HashMap<String, List<Integer>> isMap = new HashMap<>();
		int sum = 0;
		String maxk = "";
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				//如果走过的
				if(is[i]&&is[j]) continue;
				// 求tan
				String k = getK(a[i][0], a[i][1], a[j][0], a[j][1]);
				if (map.containsKey(k)) {
					// 如果有获取
					Integer knum = map.get(k);
					if(sum<knum + 1)
					{
						//如果这个是放的最多的
						sum=knum+1;
						maxk=k;
					}
					map.put(k, knum + 1);
					//获取之前存入的
					List<Integer> list = isMap.get(k);
					//加入
					list.add(i);
					list.add(j);
				} else {
					map.put(k, 1);
					//放入计算斜率的两个点
					ArrayList<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					isMap.put(k, list);
				}
			}
		}
		List<Integer> list = isMap.get(maxk);
		if(list==null) return 0;
		//获取点数最多的点 标记走过
		for (Integer index:list) {
			is[index]=true;
		}
		
		return sum*(sum-1)/2;

	}
	
	
	

	private static String getK(int x1, int y1, int x2, int y2) {
		int x = x1 - x2;
		int y = y1 - y2;
		int gcd = gcd(Math.abs(x), Math.abs(y));
		// 最简分数
		x /= gcd;
		y /= gcd;
		if ((x < 0 && y > 0) || (y < 0 && x > 0)) {
			return "-" + Math.abs(y) + "/" + Math.abs(x);
		}
		return Math.abs(y) + "/" + Math.abs(x);
	}

/*	@Test
	public void f() {
		System.out.println(gcd(Math.abs(1), Math.abs(-88)));
	}*/
	public static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}
}
