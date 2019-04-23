package com.wjw.basic02;

import java.util.Scanner;

public class _环形字符串3 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in); 
		 String str = scanner.nextLine();
		 String match = scanner.nextLine();
		 int sum = f(str, match);
		System.out.println(sum);
	}


	public static int f(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return 0;
		}
		s+=s.substring(0,  m.length()-1);
		int sum = 0;
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
		//System.out.println(sum);
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
