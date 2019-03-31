package com.wjw.basic01;

public class _汉诺塔 {

	public static void main(String[] args) {
		f(2,"left","right","mid");
	}

	private static void f(int N, String from, String to, String mid) {
		//如果只有一个
		if(N==1)
		{
			System.out.println("Move "+N+" from "+ from+" to "+to);
		}
		else
		{
			//把之前移动到 右边
			f(N-1, from, mid, to);
			//把自己移到目标
			System.out.println("Move "+N+" from "+ from+" to "+to);
			//把右边的一道中间
			f(N-1, mid, to, from);
		}
		
		
	}
}
