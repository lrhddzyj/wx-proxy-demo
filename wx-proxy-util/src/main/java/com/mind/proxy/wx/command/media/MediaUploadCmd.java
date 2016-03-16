package com.mind.proxy.wx.command.media;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.io.Files;
import com.mind.httpclient.command.Location;
import com.mind.httpclient.net.NetUtils;
import com.mind.proxy.wx.command.Constants;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.WeiXinException;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by serv on 2015/3/18.
 */
public class MediaUploadCmd extends WxJsonCommand implements Constants{

    private String fileName;
    private byte[] bytes;
    private MediaType type;

    private String mediaId;

    public MediaUploadCmd(String fileName, byte[] bytes, MediaType type) {
        super("uploadMedia");
        this.fileName = fileName;
        this.bytes = bytes;
        this.type = type;
        addVariable("type",type.toString());
    }



    @Override
    protected void doExecute() throws Exception {
        try {
            String tempFileName = Files.createTempDir().getPath()+ UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(fileName);
            File file = new File(tempFileName);
            Files.write(bytes,file);
            FileBody body = new FileBody(file);
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("media",body)
                    .addPart("filename",new StringBody(fileName, ContentType.create("text/plain", Consts.UTF_8)))
                    .addPart("filelength",new StringBody(String.valueOf(bytes.length), ContentType.create("text/plain", Consts.UTF_8)))
                    .build();
            Location location = getLocation();
            String resultText = NetUtils.post(location.getUrl(), reqEntity);
            JsonNode jsonNode = wrap2JsonNode(resultText);
            mediaId = type.isThumb()?jsonNode.path("thumb_media_id").asText():jsonNode.path("media_id").asText();
        } catch (IOException e) {
            log.error(e.getMessage(),e);
            throw new WeiXinException(90002,"上传到微信服务器出错:"+e.getMessage());
        }
    }


    public String getMediaId() {
        return mediaId;
    }

    public String getUrl(){
        return String.format(MEDIA_URL,getVariables().get("accessToken"),mediaId);
    }
}
