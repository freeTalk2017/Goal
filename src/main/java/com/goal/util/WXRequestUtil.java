package com.goal.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class WXRequestUtil {

	public static String getSilentUrl(){
		
		String url = null;
		try {
			url = "https://open.weixin.qq.com/connect/oauth2/authorize?"
					+ "appid=wxa1378048216955b0"
					+ "&redirect_uri=" + URLEncoder.encode("http://www.makeiteasy.xin/trade/check","utf-8")
					+ "&response_type=code"
					+ "&scope=snsapi_base#wechat_redirect";
		} catch (UnsupportedEncodingException e) {
			System.out.println("encode error");
		}
		return url;
	}
}
