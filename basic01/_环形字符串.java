package com.wjw.basic02;

import java.util.Scanner;

public class _环形字符串 {
	/*
	 * 长 fcibaigihdkck
短 akei
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String match = scanner.nextLine();
		System.out.println(f(str, match));
	}

	static int f(String str, String match) {
		int sum = 0;
		str += str.substring(0, match.length() - 1);

		// 依次次比较
		for (int i = 0; i < str.length(); i++) {
			// 如果相等
			if (str.charAt(i) == match.charAt(0)) {
				for (int j2 = 0; j2 < match.length(); j2++) {
					if((i + j2)==str.length()) return sum;
					
					if(str.charAt(i + j2) == match.charAt(j2) )
					{
						if (j2 == match.length() - 1)
							sum++;
					}
					else
						break;
					
				}
			}

		}
		return sum;
	}

}
