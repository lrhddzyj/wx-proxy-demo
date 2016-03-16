package com.mind.proxy.wx.command.poi;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.io.Files;
import com.mind.httpclient.command.Location;
import com.mind.httpclient.net.NetUtils;
import com.mind.proxy.wx.command.WxJsonCommand;
import com.mind.weixin.WeiXinException;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by user on 2015/6/10.
 */
public class UploadPoiImgCmd extends WxJsonCommand {

    private String retMsg ;

    private String fileName ;
    private byte[] media ;

    public UploadPoiImgCmd(String fileName, byte[] buffer) {
        super("uploadPoiImg");
        this.fileName = fileName;
        this.media = buffer ;
    }

    @Override
    protected void doExecute() throws Exception {
        try {
            String tempFileName = Files.createTempDir().getPath()+ UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(fileName);
            File file = new File(tempFileName);
            Files.write(media,file);
            FileBody body = new FileBody(file);
            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("buffer", body).build();
            Location location = getLocation();
            String resultText = NetUtils.post(location.getUrl(), reqEntity);
            JsonNode jsonNode = wrap2JsonNode(resultText);
            retMsg = jsonNode.path("url").asText();
        } catch (IOException e) {
            log.error(e.getMessage(),e);
            throw new WeiXinException(90002,"上传到微信服务器出错:"+e.getMessage());
        }
    }

    public String getRetMsg() {
        return retMsg;
    }
}
