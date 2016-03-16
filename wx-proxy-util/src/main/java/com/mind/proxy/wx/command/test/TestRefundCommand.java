package com.mind.proxy.wx.command.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.mind.httpclient.command.JacksonCommand;
//import com.mind.httpclient.net.SSLRestTemplateBuilder;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by serv on 2015/4/17.
 */
public class TestRefundCommand extends JacksonCommand {

    private String result;

    public TestRefundCommand(String json) {
        super("testRefund");
        addVariable("json",json);
    }
//
//    @Override
//    protected HttpClient getHttpClient() {
////        try {
////            return SSLRestTemplateBuilder.create()
////                    .setHostnameVerifier(SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER)
////                    .setKeyStoreType("PKCS12")
////                    .setKeyStore(Files.readAllBytes(new File("c:\\client.p12").toPath()))
////                    .setKeyStorePassword("hyxt2015")
////                    .build();
////        } catch (IOException e) {
////            return null;
////        }
//        return null;
//    }

    @Override
    protected void afterExecuted(JsonNode jsonNode, String resultText) {
        this.result = resultText;
    }

    public String getResult() {
        return result;
    }
}
