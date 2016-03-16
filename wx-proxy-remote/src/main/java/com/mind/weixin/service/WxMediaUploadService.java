package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;

/**
 * Created by serv on 2014/8/4.
 */
public interface WxMediaUploadService {

    /**
     * 上传文件post接口
     * @param wxAppId 微信公众号appId
     * @param fileName 文件名
     * @param bytes 二进制数据
     * @param type  文件类型 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @return 上传后的mediaId
     */
    public String uploadFileToWeixin(String wxAppId, String fileName, byte[] bytes, MediaType type) throws WeiXinException;

    public enum MediaType{
        image,voice,video,thumb;

        public boolean isThumb(){
            if("thumb".equals(this.toString())){
                return true;
            }
            return false;
        }

        public static MediaType toMediaType(String type){
            return MediaType.valueOf(type);
        }
    }
}
