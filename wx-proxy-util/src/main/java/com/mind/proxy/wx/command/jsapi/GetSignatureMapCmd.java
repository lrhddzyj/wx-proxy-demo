package com.mind.proxy.wx.command.jsapi;

import com.mind.httpclient.command.JacksonCommand;
import com.mind.proxy.wx.utils.SignUtils;

import java.util.TreeMap;
import java.util.UUID;

/**
 * Created by serv on 2015/3/20.
 */
public class GetSignatureMapCmd extends JacksonCommand{

    private String jsapiTicket;
    private String url;
    private TreeMap<String,String> treeMap = new TreeMap<String, String>();

    public GetSignatureMapCmd(String jsapiTicket, String url) {
        super(null);
        this.jsapiTicket = jsapiTicket;
        this.url = url;
    }

    /**
     *  noncestr=Wm3WZYTPz0wzccnW
     jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg
     timestamp=1414587457
     url=http://mp.weixin.qq.com
     signature=f4d90daf4b3bca3078ab155816175ba34c443a7b
     */
    @Override
    protected void doExecute() throws Exception {
        treeMap.put("noncestr", UUID.randomUUID().toString());
        treeMap.put("jsapi_ticket",jsapiTicket);
        treeMap.put("timestamp",String.valueOf(System.currentTimeMillis()));
        treeMap.put("url",url);
        treeMap.put("signature", SignUtils.sha1(treeMap));
    }

    public TreeMap<String, String> getTreeMap() {
        return treeMap;
    }
}
