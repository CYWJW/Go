package com.wjw.basic;

import java.util.Scanner;

public class BASIC_20
{
	
	public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        //读取数
        String line = scanner.nextLine();
        //输入基本的数
        String[] text = "yi er san si wu liu qi ba jiu shi".split(" ");
        int textLong= line.length();
        String result="";
        for (int i = 0; i <textLong; i++) {
			
        	//拼接十万以下的
        	if(i<6)
        	{
        		//判断是不是为零
        		if("0".equals(line.charAt(textLong-1-i)))
        		{
        			
        		}
        	}
        	else {
        		
        	}
		}
        
    }   
 
							                         
							                        
}
