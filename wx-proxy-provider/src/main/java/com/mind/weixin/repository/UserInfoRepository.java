package com.mind.weixin.repository;

import com.mind.weixin.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 因为所有的openId 的 collection都是动态的. 所以不建议使用该方法
 * Created by serv on 2014/11/24.
 */
@Deprecated
public interface UserInfoRepository extends MongoRepository<UserInfo,String> {

//    @Query(value = "{'openId':?0}",delete = true)
//    public Long deleteByOpenId(String openId);
}
