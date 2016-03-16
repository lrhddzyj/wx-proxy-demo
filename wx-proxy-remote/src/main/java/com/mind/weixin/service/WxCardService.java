package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.vo.card.CardBulletin;
import com.mind.weixin.vo.card.CardList;
import com.mind.weixin.vo.card.UserCardList;

import java.util.List;

/**
 * 卡卷功能
 * Created by serv on 2014/11/13.
 */
public interface WxCardService {

    /**
     * 创建卡卷 card 的json对象
     * @param appId 微信appId
     * @param cardJson json 串
     * @return
     */
    @Deprecated
    public String crateCard(String appId, String cardJson) throws WeiXinException;

    /**
     * 创建卡卷 card 的json对象
     * @param appId 微信appId
     * @param cardJson json 串
     * @return
     */
    public String createCard(String appId, String cardJson) throws WeiXinException;

    /**
     * 获取微信卡券的颜色列表
     * @param appId
     * @return
     */
    String getCardColors(String appId);

    /**
     * 生成卡券二维码
     * @param appId 微信appId
     * @param cardId 卡券 ID
     * @param code 指定卡券 code 码，只能被领一次。use_custom_code 字段  为 true 的卡券必须填写，非自定义 code 不必填写。
     * @param openId 指定领取者的 openid，只有该用户能领取。bind_openid 字段为 true 的卡券必须填写，非自定义 openid 不必填写。
     * @param expireSeconds 指定二维码的有效时间，范围是 60 ~ 1800 秒。0为永久有效。
     * @param unique 指定下发二维码，生成的二维码随机分配一个 code，领取后不可再次扫描。填写 true 或 false。默认 false。
     * @return
     */
    public String getCardTicket(String appId, String cardId, String code, String openId, int expireSeconds, boolean unique) throws WeiXinException;

    /**
     * 卡券核销
     * @param appId 微信appId
     * @param code 要消耗的序列号
     * @param cardId 要消耗序列号所述的 card_id，创建卡券时use_custom_code 填写 true 时必填。 非自定义 code不必填写。
     * @return [cardId,openId]
     */
    public List<String> consumeCard(String appId, String code, String cardId) throws WeiXinException;

    /**
     * 将加密的code 解码
     * @param appId 微信appId
     * @param encryptCode
     * @return
     */
    public String decryptCode(String appId, String encryptCode) throws WeiXinException;

    /**
     * 根据cardid 查询卡券详情
     * @param appId 微信appId
     * @param cardId
     * @return card 的json对象
     */
    public String getCardDetail(String appId, String cardId) throws WeiXinException;

    /**
     * 设置白名单
     * @param appId 微信appId
     * @param openIds openid集合
     * @param usernames 用户名集合
     */
    public void setWhiteList(String appId, List<String> openIds, List<String> usernames) throws WeiXinException;
    /**
     * 修改卡包详情
     * @param appId 微信appId
     * @param cardJson 卡包详情json
     */
    public void updateCardDetail(String appId, String cardJson) throws WeiXinException;

    /**
     * 激活、绑定会员卡
     * @param appId
     * @param json
     * @throws WeiXinException
     */
    public void activateCard(String appId, String json) throws WeiXinException;

    /**
     * 会员卡交易
     * @param appId
     * @param json
     * @throws WeiXinException
     */
    public String updateUserCard(String appId, String json) throws WeiXinException;

    /**
     * 查询code
     * @param appId
     * @param code
     * @param cardId
     * @return
     * @throws WeiXinException
     */
    public String getCode(String appId, String code, String cardId) throws WeiXinException;

    /**
     * 获取api_ticket
     * {@link #getApiTicket(String)}
     */
    @Deprecated
    public String getApiTicket(String appId, boolean force) throws WeiXinException;
    /**
     * 获取api_ticket
     * @param appId
     * @return
     * @throws WeiXinException
     */
    public String getApiTicket(String appId) throws WeiXinException;

    /**
     * 发送卡券公告
     * @param appId
     * @param info
     * @return
     */
    String sendCardBulletin(String appId, CardBulletin info);

    /**
     * 修改卡券公告
     * @param appId
     * @param info
     * @return
     */
    String updateCardBulletin(String appId, CardBulletin info);

    /**
     * 上传卡券logo
     * @param appId
     * @param fileName
     * @param buffer
     * @return
     */
    String uploadCardImg(String appId, String fileName, byte[] buffer);


    /**
     * 获取用户已领取卡券接口
     * @param appId
     * @param openId
     * @param cardId 不填时查询当前appId下的所有卡券
     * @return
     */
    UserCardList getUserCardList(String appId, String openId, String cardId);

    /**
     * 查询卡券
     * @param appId
     * @param offset 查询卡列表的起始偏移量，从0开始，即offset: 5是指从从列表里的第六个开始读取。
     * @param count 需要查询的卡片的数量（数量最大50）。
     * @param statusList  取值：
     *                    “CARD_STATUS_NOT_VERIFY”,待审核；
     *                    “CARD_STATUS_VERIFY_FALL”,审核失败；
     *                    “CARD_STATUS_VERIFY_OK”，通过审核；
     *                    “CARD_STATUS_USER_DELETE”，卡券被用户删除；
     *                    “CARD_STATUS_USER_DISPATCH”，在公众平台投放过的卡券
     * @return
     */
    CardList getCardList(String appId, String offset, String count, String... statusList);

    /**
     * 修改库存接口
     * @param appId
     * @param cardId 卡券ID。
     * @param reduceStockValue 增加多少库存，支持不填或填0。
     * @param increaseStockValue 减少多少库存，可以不填或填0。
     */
    void modifyStock(String appId, String cardId, String reduceStockValue, String increaseStockValue);

    /**
     * 删除卡券接口
     * @param appId
     * @param cardId 卡券ID。
     */
    void deleteCard(String appId, String cardId);

    /**
     * 设置卡券失效接口
     * @param appId
     * @param code 设置失效的Code码。
     * @param cardId 卡券ID。 自定义卡券必须传递 此参数，非自定义可不传
     */
    void unavailableCard(String appId, String code, String cardId);

    /**
     * 更新会员卡Code
     * @param appId
     * @param code 需变更的Code码。
     * @param cardId 卡券ID。自定义Code码卡券为必填。
     * @param newCode 变更后的有效Code码。
     */
    void updateCardCode(String appId, String code, String cardId, String newCode);
}
