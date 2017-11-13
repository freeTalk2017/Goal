package com.goal.wxpay;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.goal.wxpay.WXPayDomainSimpleImpl;
import com.goal.wxpay.WXPayConfig;
import com.goal.wxpay.WXPayConfigImpl;

public class WXPayConfigImpl extends WXPayConfig{

	private byte[] certData;
    private static WXPayConfigImpl INSTANCE;
    
    private WXPayConfigImpl() throws Exception{
    	String certPath = "D://CERT/common/apiclient_cert.p12";
    	File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }
    
    public static WXPayConfigImpl getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl();
                }
            }
        }
        return INSTANCE;
    }

	@Override
	String getAppID() {
		return "wxa1378048216955b0";
	}

	@Override
	String getMchID() {
		return "1490576662";
	}

	@Override
	String getKey() {
		return "6ac0b7bfb762290e38034fd159d8d4a6";
	}

	@Override
	InputStream getCertStream() {
		ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
	}

	@Override
	IWXPayDomain getWXPayDomain() {
		return WXPayDomainSimpleImpl.instance();
	}
	
    public String getPrimaryDomain() {
        return "api.mch.weixin.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.weixin.qq.com";
    }
    
    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }
    
    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
