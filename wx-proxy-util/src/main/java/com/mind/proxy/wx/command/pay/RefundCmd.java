package com.mind.proxy.wx.command.pay;

import com.mind.httpclient.net.SSLRestTemplateBuilder;
import com.mind.proxy.wx.command.WxXmlCommand;
import com.mind.wxpay.request.RefundRequest;
import com.mind.wxpay.response.RefundResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

/**
 * Created by serv on 2015/3/20.
 */
public class RefundCmd extends WxXmlCommand<RefundResponse> {

    private byte[] keyStore;
    private String keyStorePwd;

    public RefundCmd(RefundRequest request,String key,byte[] keyStore,String keyStorePwd) {
        super("refund", request, key);
        this.keyStore = keyStore;
        this.keyStorePwd = keyStorePwd;
    }

    @Override
    protected HttpClient getHttpClient() {
        //使用ssl加密方式访问
        HttpClient httpClient = SSLRestTemplateBuilder.create()
                .setHostnameVerifier(SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER)
                .setKeyStoreType("PKCS12")
                .setKeyStore(keyStore)
                .setKeyStorePassword(keyStorePwd)
                .build();
        return httpClient;
    }
}
