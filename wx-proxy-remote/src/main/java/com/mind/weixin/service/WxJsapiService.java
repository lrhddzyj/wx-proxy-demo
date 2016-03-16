package com.mind.weixin.service;

import java.util.Map;

/**
 * Created by serv on 2015/1/19.
 */
public interface WxJsapiService {

    /**
     *  noncestr=Wm3WZYTPz0wzccnW
        jsapi_ticket=sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg
        timestamp=1414587457
        url=http://mp.weixin.qq.com
        signature=f4d90daf4b3bca3078ab155816175ba34c443a7b
     * @param wxAppId
     * @param url
     * @return
     */
    public Map<String,String> getJsapiMap(String wxAppId, String url);
}
