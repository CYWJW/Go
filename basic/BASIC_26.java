package com.wjw.basic;

import java.util.*;

public class BASIC_26

{

	public static void main(String args[])

	{

		Scanner cn = new Scanner(System.in);
		//小时
		int h = cn.nextInt(); 
		//分钟
		int m = cn.nextInt(); 
		Map<String, String>map=new HashMap<>();
		
		String num="0:zero, 1:one, 2:two, 3:three, 4:four, "
				+ "5:five, 6:six, 7:seven, 8:eight, 9:nine, 10:ten ,11:eleven,"
				+ " 12:twelve, 13:thirteen, 14:fourteen, 30:thirty,40:forty,50:fifty, "
				+ "15:fifteen, 16:sixteen, 17:seventeen, 18:eighteen,19:nineteen,20:twenty";
		//切分每个单元
		String one[]=num.split(",");
		
		for(String string:one)
		{
			//第一个放数字 第二个放英文
			map.put(string.split(":")[0].trim(), string.split(":")[1].trim());
		}
		//小时定义
		String hString="";
		//获取小时
		if(map.get(h+"")!=null)
		{
			hString=map.get(h+"")+" ";
			
		}
		else {
			//获取个位
			int g=h%10;
			//获取十位
			int s=(h/10)*10;
			hString=map.get(s+"")+" "+map.get(g+"")+" ";
		}
		
		//获取分钟
		if(m==0)
		{
			System.out.println(hString+"o'clock");
		}
		else if(map.get(m+"")!=null)
		{
			System.out.println(hString+map.get(m+""));
		}
		else
		{
			//获取个位
			int g=m%10;
			//获取十位
			int s=(m/10)*10;
			String	mString=map.get(s+"")+" "+map.get(g+"");
			System.out.println(hString+mString);
		}
	}

	

}
