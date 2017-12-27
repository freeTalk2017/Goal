package com.goal.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * this class is used to deal with date/time related method using Apache Common utils
 * @author lizhiwei
 *
 */
public class DateUtil extends DateUtils{
	
	/**
	 * formate date - <strong>thread safe</strong>
	 * @param date
	 * @param formate
	 * @return
	 */
	public static String formateDate(Date date,String format){
		FastDateFormat fdf = FastDateFormat.getInstance(format);
		return fdf.format(date);
	}
	
	/**
	 * prase date - <strong>thread safe</strong>
	 * @param tspStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String tspStr,String format) throws ParseException{
		FastDateFormat fdf = FastDateFormat.getInstance(format);
		return fdf.parse(tspStr);
	}
	
	/**
	 * get the round date using give unit.
	 * @param unit(this para is the constant of java.util.Calander)
	 * @return
	 */
	public static Date roundByUnit(Date date,int unit){
		return DateUtils.round(date, unit);
	}
	

	/**
	 * get the truncate date using give unit.
	 * @param unit(this para is the constant of java.util.Calander)
	 * @return
	 */
	public static Date truncateByUnit(Date date,int unit){
		return DateUtils.truncate(date, unit);
	}
	
	/**
	 * get system date for wxpay.
	 * @return
	 */
	public static String getSystemDate(){
		long timeLong = System.currentTimeMillis();
		timeLong /= 1000.0;
		return Long.toString(timeLong);
		
	}
}
