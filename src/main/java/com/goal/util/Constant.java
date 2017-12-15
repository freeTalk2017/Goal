package com.goal.util;

/**
 * 此接口用作记录常量
 * 
 * @author lizhiwei
 *
 */
public interface Constant {
	/**图片展示顺序**/
	/*第一*/
	public static final String PICTURE_INDEX_FIRST = "1";
	
	/*第二*/
	public static final String PICTURE_INDEX_SECOND = "2";
	
	/*第三*/
	public static final String PICTURE_INDEX_THRID = "3";

	/**图片展示为**/
	/*首页slider图片*/
	public static final String PICTURE_SHOW_AS_HOMEPAGE_SLIDER="1";
	
	/*商品详情页商品展示图片*/
	public static final String PICTURE_SHOW_AS_SHOW_DETAIL = "2";
	
	/*首选-无论从首页，还是其它地方显示的首选图片*/
	public static final String PICTURE_SHOW_AS_FIRST_CHOICE = "3";

	/*商品也展示图片*/
	public static final String PICTURE_SHOW_AS_CMD_DETAIL_SLIDER = "4";
	
	/*商品详情页描述图片*/
	public static final String PICTURE_SHOW_AS_SHOW_DESC = "5";
	
	/**系列级别**/
	/*系列顶级*/
	public static final String SERIAL_LEVEL_TOP = "1";
	/*系列第二级*/
	public static final String SERIAL_LEVEL_SECOND = "2";
	/*系列第三级*/
	public static final String SERIAL_LEVEL_THIRD = "3";
	
	/**订单状态**/
	/*订单超时未付款*/
	public static final String ORDER_STATUS_UNPAY = "0";
	/*订单初始化*/
	public static final String ORDER_STATUS_INIT = "1";
	/*订单已付款*/
	public static final String ORDER_STATUS_PAYED = "2";
	/*订单已发货*/
	public static final String ORDER_STATUS_SENT = "3";
	/*订单已完成*/
	public static final String ORDER_STATUS_COMPLETED = "4";
	
	
	/**
	 * 符号
	 */
	public static final String SYMBOL_STRIP="-";
}
