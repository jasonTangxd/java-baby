package com.xxo.day20.work;

import java.util.Calendar;
import java.util.Date;

public class Demo7 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date time = calendar.getTime();
		System.out.println(time);
	}
}
