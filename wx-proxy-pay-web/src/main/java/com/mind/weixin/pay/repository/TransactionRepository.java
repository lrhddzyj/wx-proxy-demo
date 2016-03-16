package com.mind.weixin.pay.repository;

import com.mind.weixin.pay.entity.TransactionDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by serv on 2014/12/3.
 */
public interface TransactionRepository extends MongoRepository<TransactionDocument,String> {

    //shopId = ? and storeId = ? and timeStart >= ? and timeStart <= ?
    @Query(value = "{'shopId' : ?0,'storeId' : ?1 ,'createTime':{'$gte' : ?2,'$lte' : ?3}}")
    public Page<TransactionDocument> findByShopIdAndStoreId(String shopId, String storeId, Date timeStart, Date timeEnd, Pageable pageable);

    //shopId = ? and storeId = ? and timeStart >= ? and timeStart <= ?
    @Query(value = "{'shopId' : ?0,'createTime':{'$gte' : ?1,'$lte' : ?2}}")
    public Page<TransactionDocument> findByShopId(String shopId, Date timeStart, Date timeEnd, Pageable pageable);

    /**
     * 根据订单号获取订单详情
     * @param outTradeNo
     * @return
     */
    public TransactionDocument findByOutTradeNo(String outTradeNo);
    /**
     * 根据业务主键获取所有订单列表
     * @param businessSystemId
     * @return
     */
    public List<TransactionDocument> findByBusinessSystemId(String businessSystemId);

    @Query(value = "{'timeStart':{'$gte' : ?0}}")
    public List<TransactionDocument> findUnPay(long time);

    public TransactionDocument findByPrepayId(String prepayId) ;



}
