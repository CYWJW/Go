package com.wjw.basic01;

import java.util.Arrays;
/**
 * kmp
 * @author 汪军伍
 *
 */
public class KMP {
	public static void main(String[] args) {
		String longStr="adaabc";
		String str="abc";
		//获取前缀码
		int[] pre = getPre(str);
		System.out.println(Arrays.toString(pre));
		boolean is = getIndex(pre,longStr,str);
		System.out.println(is);
	}

	private static boolean getIndex(int[] pre, String longStr, String str) {
		char[] longStrs = longStr.toCharArray();
		char[] strs = str.toCharArray();
		//长字符指针
		int l=0;
		//短字符指针
		int s=0;
		while (s<str.length() && l<longStr.length()) {
			//先两个指针比较 如果正确
			if(strs[s]==longStrs[l])
			{
				//如果比较完成
				if(s==strs.length-1)
				{
					return true;
				}
				s++;
				l++;
			}
			else if (s>0) {
				s=pre[s];
			}
			//如果已经和第一个比了 并且没过
			else {
				l++;
			}
		}
		return false;
 	}

	private static int[] getPre(String str) {
		//创建新的数组
		int[] a=new int[str.length()];
		a[0]=-1;
		a[1]=0;
		int cpare=0;
		int i=2;
		while (i<str.length()) {
			if(str.charAt(i-1)==str.charAt(cpare))
			{
				//如果相同当前数组为比较+1  比较指向下一个
				a[i++]=++cpare;
			}
			//如果比较的大于0
			else if (cpare>0) {
				cpare=a[cpare];
			}
			else
			{
				//如果没有就默认为0 +1
				i++;
			}
		}
		return a;
	}
}
