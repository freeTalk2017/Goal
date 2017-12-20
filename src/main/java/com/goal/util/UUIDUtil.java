package com.goal.util;

import java.util.UUID;

/**
 * UUID工具类
 * @author lizhiwei
 *
 */
public class UUIDUtil {
	/**
	 * 取得去掉-号的UUID
	 * @return
	 */
	public static String getUUIDWithoutStrip() {
		return UUID.randomUUID().toString().replace(Constant.SYMBOL_STRIP, "");
	}

	/**
	 * 取得UUID
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			System.out.println(getUUIDWithoutStrip());
		}
	}
}
