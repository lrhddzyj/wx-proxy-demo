package com.mind.weixin.service;

import com.mind.proxy.wx.command.poi.*;
import com.mind.weixin.vo.poi.PoiBaseInfo;
import com.mind.weixin.vo.poi.PoiInfo;
import com.mind.weixin.vo.poi.PoiPageInfo;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2015/6/10.
 */
@Service
public class WxPoiServiceImpl extends BaseService implements WxPoiService {

    @Override
    public String AddPoi(String appId ,PoiBaseInfo poiBaseInfo) {
        return execToken(appId, new AddPoiCmd(poiBaseInfo)).getRetMsg();
    }

    @Override
    public String delPoi(String appId, String poiId) {
        return execToken(appId,new DelPoiCmd(poiId)).getRetMsg();
    }

    @Override
    public PoiInfo getPoiInfo(String appId, String poiId) {
        return execToken(appId,new GetPoiCmd(poiId)).getPoiInfo();
    }

    @Override
    public PoiPageInfo getPoiListInfo(String appId, String begin, String limit) {
        PoiPageInfo poiPageInfo = execToken(appId, new GetPoiListCmd(begin, limit)).getPoiPageInfo();
        return poiPageInfo;
    }

    @Override
    public String updatePoiInfo(String appId, PoiBaseInfo poiBaseInfo) {
        String retMsg = execToken(appId, new UpdatePoiCmd(poiBaseInfo)).getRetMsg();
        return retMsg;
    }

    @Override
    public String uploadPoiImg(String appId, String fileName, byte[] buffer) {
        String retMsg = execToken(appId, new UploadPoiImgCmd(fileName, buffer)).getRetMsg();
        return retMsg;
    }
}
