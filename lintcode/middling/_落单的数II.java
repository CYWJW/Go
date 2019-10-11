package com.wjw.lintcode.middling;

import java.util.Scanner;

public class _落单的数II {
	static String result = "";

	public static void main(String[] args) {

		final Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				result+="a";
			}
		});
		
		final Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				
				try {
					t1.join();
					result+="b";
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t3=new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				result+="c";
			}
		});
		
		
		
		t1.start();
		t2.start();
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);

		
		
		
	}
}
