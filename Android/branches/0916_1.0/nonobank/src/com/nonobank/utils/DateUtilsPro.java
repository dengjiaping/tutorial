package com.nonobank.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.text.format.DateFormat;

public class DateUtilsPro {

	/**
	 * 将时间戳字符串转换为时间字符串 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static String stampToDateStr(String strDate) {
		Long timestamp = Long.parseLong(strDate) * 1000;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(new java.util.Date(timestamp));
		return dateStr;
	}

	/**
	 * 将时间戳字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date stampToDate(String strDate) {
		String dateStr = stampToDateStr(strDate);
		return StringToDate(dateStr, "yyyy-MM-dd");
	}

	/**
	 * 将字符串转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 日期
	 */
	public static Date StringToDate(String dateStr, String formatStr) {
		SimpleDateFormat dd = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = dd.parse(dateStr);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("转换日期错误");
		}
	}

	/**	
	 * 获取当前的时间
	 */
	public static String getCurrDateStr() {
		Date date=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	/**
	 * date转String
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * 获取日期的月份。失败返回0。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 月份
	 */
	public static int getMonth(String dateStr) {
		Date date = new Date();
		date = StringToDate(dateStr, "yyyy-MM-dd");
		return getInteger(date, Calendar.MONTH);
	}

	/**
	 * 获取日期中的某数值。如获取月份
	 * 
	 * @param date
	 *            日期
	 * @param dateType
	 *            日期格式
	 * @return 数值
	 */
	private static int getInteger(Date date, int dateType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(dateType) + 1;
	}

	/**
	 * 两个时间之间的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间
		Date date = StringToDate(date1, "yyyy-MM-dd");
		Date mydate = StringToDate(date2, "yyyy-MM-dd");
		int day = (int) ((date.getTime() - mydate.getTime()) /(3600*24*1000));
		return day;
	}

	/**
	 * 两个时间之间的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDays(Date date1, Date date2) {
		int day = (int) ((date1.getTime() - date1.getTime()) /(3600*24*1000));
		return day;
	}

	/** 保留两位小数 */
	public  static String getTwoDecimals(double num){
		DecimalFormat df=new DecimalFormat(".##");
		String string=df.format(num);
		return string;
	}
}
