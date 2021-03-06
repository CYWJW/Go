package com.wjw.basic;

import java.util.Scanner;

/*
标题：矩阵翻硬币

    小明先把硬币摆成了一个 n 行 m 列的矩阵。

    随后，小明对每一个硬币分别进行一次 Q 操作。

    对第x行第y列的硬币进行 Q 操作的定义：将所有第 i*x 行，第 j*y 列的硬币进行翻转。

    其中i和j为任意使操作可行的正整数，行号和列号都是从1开始。

    当小明对所有硬币都进行了一次 Q 操作后，他发现了一个奇迹——所有硬币均为正面朝上。

    小明想知道最开始有多少枚硬币是反面朝上的。于是，他向他的好朋友小M寻求帮助。

    聪明的小M告诉小明，只需要对所有硬币再进行一次Q操作，即可恢复到最开始的状态。然而小明很懒，不愿意照做。于是小明希望你给出他更好的方法。帮他计算出答案。

【数据格式】
    输入数据包含一行，两个正整数 n m，含义见题目描述。
    输出一个正整数，表示最开始有多少枚硬币是反面朝上的。

【样例输入】
2 3

【样例输出】
1

【数据规模】
对于10%的数据，n、m <= 10^3；
对于20%的数据，n、m <= 10^7；
对于40%的数据，n、m <= 10^15；
对于100%的数据，n、m <= 10^1000（10的1000次方）。

资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms


请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。

所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。

*/


public class 贪心 {
 static int a[]= {64,16,4,1};
  public static void main(String[] args) {
	  Scanner scanner=new Scanner(System.in);
	  //读取价值
	  int price = scanner.nextInt();
	  int total=0;
	  int num=	1024-price;
	  
	  //读取64元的
	  if((num/64)>0)
	  {
		  total+=num/64;
		  num=num-total*64;
	  }
	  
	  if((num/16)>0)
	  {
		  int a=num/16;
		  total+=num/16;
		  
		  num=num-a*16;
	  }
	  
	  if((num/4)>0)
	  {
		  int a=num/4;
		  total+=num/4;
		  num=num-a*4;
	  }
	  
	  if((num/1)>0)
	  {
		  total+=num/1;
	  }
	  System.out.println(total);
	  
	  
	  
  }
}
