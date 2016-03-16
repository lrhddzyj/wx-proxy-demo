package com.mind.weixin.service;

import com.mind.proxy.wx.command.media.MediaUploadCmd;
import org.springframework.stereotype.Service;

/**
 * Created by serv on 2014/7/30.
 */
@Service
public class WxMediaUploadServiceImpl extends BaseService implements WxMediaUploadService {


    @Override
    public String uploadFileToWeixin(String wxAppId, String fileName, byte[] bytes, MediaType type) {
        return execToken(wxAppId,new MediaUploadCmd(fileName,bytes, com.mind.proxy.wx.command.media.MediaType.toMediaType(type.name()))).getMediaId();
    }
}
