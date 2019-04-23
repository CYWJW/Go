package com.wjw.basic02;

import java.util.Scanner;

public class _环形字符串2 {

	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 300;
		int maxValue = 10;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			char[] arr = generateRandomArray(maxSize, maxValue);
			char[] arr01 = generateRandomArray(11, maxValue);
			
			String str = new String(arr);
			String match = new String(arr01);
			//********************************************************//
			int res = _环形字符串3.f(str, match);
			//********************************************************//
			int comp = _环形字符串.f(str, match);
			if (res != comp) {
				succeed = false;
				System.out.println("长 "+str);
				System.out.println("短 "+match);
				System.out.println("测试"+res+" 对的" +comp);
				break;
			}
		}

		/*
		 * Scanner scanner = new Scanner(System.in); String str = scanner.nextLine();
		 * String match = scanner.nextLine();
		 */
		
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

	// for test
	public static char[] generateRandomArray(int maxSize, int maxValue) {
		char[] arr = new char[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) ((maxValue + 1) * Math.random()+97);
		}
		return arr;
	}

	public static int f(String s, String m) {
		int sum = 0;
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			System.out.println(-1);
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		// 长指针
		int si = 0;
		// 短指针
		int mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length) {
			// 如果两个相等
			if (ss[si] == ms[mi]) {
				// 如果已经比完
				if (mi == ms.length - 1) {
					// 加一
					sum++;
					// 如果是-1肯定到0
					if (next[mi] == -1) {
						si++;
					} else {
						mi = next[mi];
					}

				} else {
					si++;
					mi++;
				}
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return sum;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}

}
