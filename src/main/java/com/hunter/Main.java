package com.hunter;

import java.util.Date;

import com.hunter.utils.DateUtil;

public class Main {

	public static void main(String[] args) {
		Date now = DateUtil.getCurrentDateTime();
		System.out.println(now);
		String date = DateUtil.getFormatDate(now, DateUtil.PT_DD_MM_YYYY);
		System.out.println(date);
//		System.out.println(DateUtil.getFormatDate(date, DateUtil.PT_DD_MM_YYYY_HH_MM_SS));
	}
	
}
