package com.wjw.basic;

import java.util.Scanner;

public class BASIC_22
{
	
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println(cal(scanner.nextInt()));
 
    }   
 
    static String cal(int n)
    {
        if(n==1)
        {
            return "A";
        }
        else {
            return cal(n-1)+(char)('A'+n-1)+cal(n-1);
        }
    }
   /* 
      AB AC AB AD AB AC AB AE AB AC AB AD AB AC AB   A
      AB AC AB AD AB AC AB    A
      AB AC AB    A
      AB    A
      	A
							                         
							                         *
							                         */
}
