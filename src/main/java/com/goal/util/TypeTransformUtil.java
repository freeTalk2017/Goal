package com.goal.util;

import java.text.ParseException;

/**
 * 类型转换工具类
 * @author lizhiwei
 *
 */
public class TypeTransformUtil {
	/**
	 * 字符串转int
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static int stringToInt(String str) throws Exception{
		if(StringUtil.isEmpty(str)) {
			throw new ParseException(str, 0);
		}
		return new Integer(str).intValue();
	}
	
	
	public static void main(String[] args) {
		String str = "1.1";
		try {
			System.out.println(stringToInt(str));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
