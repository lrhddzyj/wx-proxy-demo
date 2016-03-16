package com.mind.proxy.wx.command.shakearound;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.io.Files;
import com.mind.httpclient.command.Location;
import com.mind.httpclient.net.NetUtils;
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
 * Created by serv on 2015/5/15.
 */
public class AddMaterialCmd extends WxJsonCommand {

    private byte[] media;
    private String fileName;

    private String picUrl;

    public AddMaterialCmd(String fileName,byte[] media) {
        super("addMaterial");
        this.fileName = fileName;
        this.media = media;
    }

    @Override
    protected void doExecute() throws Exception {
        try {
            String tempFileName = Files.createTempDir().getPath()+ UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(fileName);
            File file = new File(tempFileName);
            Files.write(media,file);
            FileBody body = new FileBody(file);
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addPart("media",body)
                    .addPart("filename",new StringBody(fileName, ContentType.create("text/plain", Consts.UTF_8)))
                    .addPart("filelength",new StringBody(String.valueOf(media.length), ContentType.create("text/plain", Consts.UTF_8)))
                    .build();
            Location location = getLocation();
            String resultText = NetUtils.post(location.getUrl(), reqEntity);
            JsonNode jsonNode = wrap2JsonNode(resultText);
            picUrl = jsonNode.path("data").path("pic_url").asText();
        } catch (IOException e) {
            log.error(e.getMessage(),e);
            throw new WeiXinException(90002,"上传到微信服务器出错:"+e.getMessage());
        }
    }

    public String getPicUrl() {
        return picUrl;
    }
}
