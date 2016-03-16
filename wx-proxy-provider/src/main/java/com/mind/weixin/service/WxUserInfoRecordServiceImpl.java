package com.mind.weixin.service;

import com.mind.weixin.WeiXinException;
import com.mind.weixin.utils.BeanMapper;
import com.mind.weixin.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Created by serv on 2014/11/24.
 */
@Service
public class WxUserInfoRecordServiceImpl implements WxUserInfoRecordService{

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BeanMapper beanMapper;

    @Autowired
    WxUserService userService;

    @Override
    public UserInfo getUserInfo(String appId , String openId) {
        com.mind.weixin.entity.UserInfo userInfo = mongoTemplate.findOne(Query.query(Criteria.where("openId").is(openId)), com.mind.weixin.entity.UserInfo.class, appId);
        //如果mongo中没有用户信息，则通过api同步用户信息
        if(userInfo==null){
            return userService.userInfoByOpenId(appId, openId);
        }
        return beanMapper.map(userInfo,UserInfo.class);
    }

    @Override
    public void saveUserInfo(UserInfo userInfo) throws WeiXinException {
        com.mind.weixin.entity.UserInfo userInfoEntity = mongoTemplate.findOne(Query.query(Criteria.where("openId").is(userInfo.getOpenId())), com.mind.weixin.entity.UserInfo.class,userInfo.getAppId());
        if(userInfoEntity!=null){
            beanMapper.map(userInfo,userInfoEntity);
            mongoTemplate.save(userInfoEntity,userInfo.getAppId());
            return;
        }
//        mongoTemplate.remove(Query.query(Criteria.where("openId").is(userInfo.getOpenId())), com.hyxt.weixin.entity.UserInfo.class, userInfo.getAppId());
        mongoTemplate.save(beanMapper.map(userInfo, com.mind.weixin.entity.UserInfo.class),userInfo.getAppId());
    }

    @Override
    public void updateKissTime(String appId, String openId, String kissTime) {
        mongoTemplate.updateMulti(Query.query(Criteria.where("openId").is(openId)),Update.update("kissTime",kissTime),com.mind.weixin.entity.UserInfo.class,appId);
    }
}
