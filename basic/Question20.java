package com.wjw.basic;

import java.util.Calendar;
import java.util.Date;

public class Question20 {
	public static void main(String[] args) {
		//日期api
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2019);
		calendar.set(Calendar.MONTH,2);
		calendar.set(Calendar.DAY_OF_MONTH,9);
		int i = calendar.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(i);
		
	}
}
