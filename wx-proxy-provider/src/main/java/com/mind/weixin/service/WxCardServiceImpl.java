package com.mind.weixin.service;

import com.google.common.collect.Lists;
import com.mind.proxy.wx.command.card.*;
import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.card.CardBulletin;
import com.mind.weixin.vo.card.CardList;
import com.mind.weixin.vo.card.UserCardList;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by serv on 2014/12/29.
 */
@Service
public class WxCardServiceImpl extends BaseService implements WxCardService {

    @Override
    public String crateCard(String appId, String cardJson) {
        return createCard(appId,cardJson);
    }

    @Override
    public String createCard(String appId, String cardJson) throws WeiXinException {
        return execToken(appId,new CreateCardCmd(cardJson)).getCardId();
    }

    @Override
    public String getCardColors(String appId){
        return execToken(appId,new GetCardColorsCmd()).getRetMsg();
    }

    @Override
    public String getCardTicket(String appId, String cardId, String code, String openId, int expireSeconds, boolean unique) {
        return execToken(appId,new GetCardTicketCmd(cardId,code,openId,expireSeconds,unique)).getTicket();
    }

    @Override
    public List<String> consumeCard(String appId, String code, String cardId) {
        ConsumeCardCmd consumeCardCmd = execToken(appId, new ConsumeCardCmd(code, cardId));
        return Lists.newArrayList(consumeCardCmd.getCardId(), consumeCardCmd.getOpenId());
    }

    @Override
    public String decryptCode(String appId, String encryptCode) {
        return execToken(appId,new DecryptCodeCmd(encryptCode)).getCode();
    }

    @Override
    public String getCardDetail(String appId, String cardId) {
        return execToken(appId,new GetCardDetailCmd(cardId)).getCardJson();
    }

    @Override
    public void setWhiteList(String appId, List<String> openIds, List<String> usernames) {
        execToken(appId,new SetWhiteListCmd(openIds,usernames));
    }

    @Override
    public void updateCardDetail(String appId, String cardJson) {
        execToken(appId,new UpdateCardDetail(cardJson));
    }

    @Override
    public void activateCard(String appId, String json) throws WeiXinException {
        execToken(appId,new ActivateCard(json));
    }

    @Override
    public String updateUserCard(String appId, String json) throws WeiXinException {
        return execToken(appId,new UpdateUserCard(json)).getResult();
    }

    @Override
    public String getCode(String appId, String code , String cardId) throws WeiXinException {
        return execToken(appId,new GetCodeCmd(code,cardId)).getResultJson();
    }

    @Override
    public String getApiTicket(String appId,boolean force) throws WeiXinException {
        return getApiTicket(appId);
    }

    @Override
    public String getApiTicket(String appId) throws WeiXinException {
        String ticket = redisTemplate.boundValueOps(WX_CARD_JSAPI_TICKET_KEY_PREFIX+appId).get();
        if(StringUtils.isNotEmpty(ticket)){
            return ticket;
        }
        return buildApiTicket(appId);
    }

    private String buildApiTicket(String appId){
        String ticket = execToken(appId, new ApiTicketCmd()).getTicket();
        //TOKEN 的有效期是7200秒,这里设置为7000秒后自动清除,以方便获取新的token
        redisTemplate.boundValueOps(WX_CARD_JSAPI_TICKET_KEY_PREFIX+appId).set(ticket, 7000, TimeUnit.SECONDS);
        return ticket;
    }

    @Override
    public String sendCardBulletin(String appId,CardBulletin info){
        String resultText = execToken(appId, new SendCardBulletinCmd(info)).getResultText();
        return resultText;
    }

    @Override
    public String updateCardBulletin(String appId,CardBulletin info){
        String resultText = execToken(appId, new UpdateCardBulletinCmd(info)).getResultText();
        return resultText;
    }

    @Override
    public String uploadCardImg(String appId, String fileName, byte[] buffer){
        String retMsg = execToken(appId, new UploadCardImgCmd(fileName, buffer)).getRetMsg();
        return retMsg;
    }

    @Override
    public UserCardList getUserCardList(String appId,String openId,String cardId){
        UserCardList list = execToken(appId, new GetUserCardListCmd(openId, cardId)).getCardList();
        return list ;

    }

    @Override
    public CardList getCardList(String appId,String offset,String count,String ... statusList){
        CardList cardList = execToken(appId, new BatchGetCardCmd(offset, count, statusList)).getCardList();
        return cardList ;
    }

    @Override
    public void modifyStock(String appId,String cardId,String reduceStockValue,String increaseStockValue ){
        execToken(appId,new ModifyStockCmd(cardId,reduceStockValue,increaseStockValue));
    }

    @Override
    public void deleteCard(String appId, String cardId){
        execToken(appId,new DeleteCardCmd(cardId));
    }
    @Override
    public void unavailableCard(String appId, String code,String cardId){
        execToken(appId,new UnavailableCardCmd(code,cardId));
    }

    @Override
    public void updateCardCode(String appId, String code, String cardId, String newCode) {
        execToken(appId,new UpdateCardCodeCmd(code,cardId,newCode));
    }



}
