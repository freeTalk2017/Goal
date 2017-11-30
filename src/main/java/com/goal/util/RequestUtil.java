package com.goal.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class RequestUtil {

	public static Logger logger = LoggerFactory.getLogger(RequestUtil.class);
	
	public void doGetUrl(String url,boolean isCode) throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response;
		String result;
		try {
			httpGet.setHeader("User-Agent","Mozilla/5.0 (Linux; U; Android 2.3.6; zh-cn; GT-S5660 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/4.5.255");
			httpGet.setHeader("Referer", "https://mp.weixin.qq.com");
			response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity);
			logger.debug(result);
		} catch (IOException e) {
			logger.error("get request error");
			throw new Exception("execute GET request error！{}", e);
		}
	}
	
	public JSONObject doGetUrl(String url) throws Exception{
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response;
		String result;
		
		try {
			response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity);
		} catch (IOException e) {
			logger.error("get request error");
			throw new Exception("execute GET request error！{}", e);
		}
				
		return JSONObject.parseObject(result);
		
	}
	
	public JSONObject doPostUrl(String url, String param) throws ClientProtocolException, IOException{
		
		final String CONTENT_TYPE_TEXT_JSON = "application/json";
		DefaultHttpClient httpClient = new DefaultHttpClient(new PoolingClientConnectionManager());
		HttpPost post = new HttpPost(url);
		HttpResponse response;
		String result = null;
		
		try {
			StringEntity stringEntity = new StringEntity(param);
			stringEntity.setContentType(CONTENT_TYPE_TEXT_JSON);
			stringEntity.setContentEncoding("UTF-8");
			post.setEntity(stringEntity);
			response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("post request error");
			//throw new Exception("execute POST request error！{}", e);
		}
		return JSONObject.parseObject(result);
		
	}
}
