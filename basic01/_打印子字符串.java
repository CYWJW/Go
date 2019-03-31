package com.wjw.basic01;

public class _打印子字符串 {

	public static void main(String[] args) {
		f("abc","",0);
	}

	private static void f(String string,String str,int N) {
		if(N==string.length()) System.out.println(str);
		else {
			//我要这个
			f(string, str+string.charAt(N), N+1);
			//我不要这个
			f(string, str, N+1);
		}
	}
}
