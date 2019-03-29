package com.wjw.basic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
取球博弈

两个人玩取球的游戏。
一共有N个球，每人轮流取球，每次可取集合{n1,n2,n3}中的任何一个数目。
如果无法继续取球，则游戏结束。
此时，持有奇数个球的一方获胜。
如果两人都是奇数，则为平局。

假设双方都采用最聪明的取法，
第一个取球的人一定能赢吗？
试编程解决这个问题。

输入格式：
第一行3个正整数n1 n2 n3，空格分开，表示每次可取的数目 (0<n1,n2,n3<100)
第二行5个正整数x1 x2 ... x5，空格分开，表示5局的初始球数(0<xi<1000)

输出格式：
一行5个字符，空格分开。分别表示每局先取球的人能否获胜。
能获胜则输出+，
次之，如有办法逼平对手，输出0，
无论如何都会输，则输出-

例如，输入：
1 2 3
1 2 3 4 5

程序应该输出：
+ 0 + 0 -

再例如，输入：
1 4 5
10 11 12 13 15

程序应该输出：
0 - 0 + +

再例如，输入：
2 3 5
7 8 9 10 11

程序应该输出：
+ 0 0 0 0


资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 3000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
*/

/*
1 7 8
900 901 903 905 907
0 + - - + */
public class _09取球博弈2 {

	static class Node{
		int num;
		char result;
		
		Node node01;
		Node node02;
		Node node03;
	}
	
	
	private static int[] n;
	static List<Integer>list=	new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = new int[3];
		for (int i = 0; i < 3; i++) {
			n[i] = sc.nextInt();
		}
		int balls[] = new int[5];
		for (int i = 0; i < 5; i++) {
			balls[i] = sc.nextInt();
		}
		Arrays.sort(n);
		for (int i = 0; i < balls.length; i++) {
			System.out.println(getBall(balls[i], 0, 0,0));
		}

	}

	/**
	 * 
	 * @param i
	 *            球数
	 * @param me
	 *            我的球
	 * @param you
	 *            他的球
	 * @return
	 */
	static char getBall(int num, int me, int you,int s) {
		// 如果不够取了 判定结果
		if (n[0] > num) {
			// 如果都是奇数或者都是偶数
			  if ((me&1)==1&&(you&1)==0)return '+';
		      else if ((me&1)==0&&(you&1)==1)return '-';
		      else return '0';
		}
		boolean flag = false;
		for (int i = 0; i < n.length; i++) {
			// 取球
			int nums = n[i];
			// 取球结束 下一轮时 我的球就是对方的球
			if (nums <= num) {
				char result = getBall(num - nums, you, me + nums,s+1);
				// 判断一个结果 如果对方输了 那么我就走这一步
				if (result == '-') {
					//如果是我
					return '+';
				}
				// 如果对方任意有一个平的话
				else if (result == '0') {
					flag = true;
				}
			}
		}
		if (flag) {
			return '0';
		}
		// 如果对方没有一把能输 那么我就必输了 并且没有一把能赢
		return '-';
	}

}
