package com.mind.weixin.service;

import com.mind.weixin.vo.poi.PoiBaseInfo;
import com.mind.weixin.vo.poi.PoiInfo;
import com.mind.weixin.vo.poi.PoiPageInfo;

/**
 * Created by user on 2015/6/10.
 *
 * 门店管理接口为商户提供门店批量导入、查询、修改、删除等主要功能，方便商户快速、高效进店管理和操作。
 * 商户在使用门店管理接口时需注意以下几个问题：
 *  门店信息全部需要经过审核方能生效，门店创建完成后，只会返回创建成功提示，并不能
 * 获得poi_id，只有经过审核后才能获取poi_id，收到微信推送的审核结果通知，并使用在微
 * 信各个业务场景中；
 *  为保证在审核通过后，获取到的poi_id 能与商户自身数据做对应，将会允许商户在创建时
 * 提交自己内部或自定义的sid(字符串格式，微信不会对唯一性进行校验，请商户自己保证)，
 * 用于后续获取poi_id 后对数据进行对应；
 *  门店的可用状态available_state，将标记门店相应审核状态，只有审核通过状态，才能进行
 * 更新，更新字段仅限扩展字段（表1 中前11 个字段）；
 *  扩展字段属于公共编辑信息，提交更新后将由微信进行审核采纳，但扩展字段更新并不影
 * 响门店的可用状态（即available_state 仍为审核通过），但update_status 状态变为1，更新中
 * 状态，此时不可再次对门店进行更新，直到微信审核采纳后；
 *  在update_status 为1，更新中状态下的门店，此时调用getpoi 接口，获取到的扩展字段为更
 * 新的最新字段，但并不是最终结果，仍需等待微信编辑对扩展字段的建议进行采纳后，最
 * 终决定是否生效（有可能更新字段不被采纳）；
 */


public interface WxPoiService {

    /**
     * 创建门店接口是为商户提供创建自己门店数据的接口，门店数据字段越完整，商户页面展示越丰
     * 富，能够更多的吸引用户，并提高曝光度。
     * 创建门店接口调用成功后会返回errcode、errmsg，但不会实时返回poi_id。成功创建后，门店信
     * 息会经过审核，审核通过后方可使用，并获取poi_id，该id 为门店的唯一id，强烈建议自行存
     * 储该id，并为后续调用使用。
     *
     * @param appId
     * @param poiBaseInfo
     * @return
     */
    String AddPoi(String appId, PoiBaseInfo poiBaseInfo);

    /**
     * 商户可以通过该接口，删除已经成功创建的门店。请商户慎重调用该接口，门店信息被删除后，
     * 可能会影响其他与门店相关的业务使用，如卡券等。同样，该门店信息也不会在微信的商户详情
     * 页显示，不会再推荐入附近功能。
     *
     * @param appId
     * @param poiId
     * @return
     */
    String delPoi(String appId, String poiId) ;

    /**
     * 在审核通过并获取poi_id 后，商户可以利用poi_id，查询具体某条门店的信息。若在查询时，
     * update_status 字段为1，表明在5 个工作日内曾用update 接口修改过门店扩展字段，该扩展字段
     * 为最新的修改字段，尚未经过审核采纳，因此不是最终结果。最终结果会在5 个工作日内，最终
     * 确认是否采纳，并前端生效（但该扩展字段的采纳过程不影响门店的可用性，即available_state
     * 仍为审核通过状态）
     * *注：扩展字段为公共编辑信息（大家都可修改），修改将会审核，并决定是否对修改建议进行采
     * 纳，但不会影响该门店的生效可用状态
     * @param appId
     * @param poiId
     * @return
     */
    PoiInfo getPoiInfo(String appId, String poiId);

    /**
     * 商户可以通过该接口，批量查询自己名下的门店list，并获取已审核通过的poi_id（审核中和审
     * 核驳回的不返回poi_id）、商户自身sid 用于对应、商户名、分店名、地址字段。
     *
     * 未审核通过，有poi_id，全部字段；
     * 未审核不通过，无poi_id，仅有基础字段
     * @param appId
     * @param begin
     * @param limit
     * @return
     */
    PoiPageInfo getPoiListInfo(String appId, String begin, String limit);


    /**
     * 商户可以通过该接口，修改门店的服务信息，包括：图片列表、营业时间、推荐、特色服务、简
     * 介、人均价格、电话7 个字段。目前基础字段包括（名称、坐标、地址等不可修改）
     *
     * 目前只能修改如下字段信息。
     *  "poId"
     *  "telephone"
     *  "photoList"
     *  "recommend"
     *  "special"
     *  "introduction"
     *  "openTime"
     *  "avgPrice"
     *
     * 字段说明：
     * 全部字段内容同前，特别注意，以上7 个字段，若有填写内容则为覆盖更新，若无内容则视为不
     * 修改，维持原有内容。photo_list 字段为全列表覆盖，若需要增加图片，需将之前图片同样放入
     * list 中，在其后增加新增图片。如：已有A、B、C 三张图片，又要增加D、E 两张图，则需要调
     * 用该接口，photo_list 传入A、B、C、D、E 五张图片的链接。
     * @param appId
     * @param poiBaseInfo
     * @return
     */
    String updatePoiInfo(String appId, PoiBaseInfo poiBaseInfo);

    String uploadPoiImg(String appId, String fileName, byte[] buffer);
}
