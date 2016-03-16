package com.mind.weixin.service;

import com.mind.proxy.wx.command.group.*;
import com.mind.weixin.service.WxGroupService;
import com.mind.weixin.vo.Group;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by serv on 2014/7/26.
 */
@Service
public class WxGroupServiceImpl extends BaseService implements WxGroupService {

    @Override
    public Group createGroup(String wxAppId, String groupName) {
        return execToken(wxAppId, new CreateGroupCmd(groupName)).getGroup();
    }

    @Override
    public List<Group> searchAllGroups(String wxAppId) {
        return execToken(wxAppId,new SearchGroupInfosCmd()).getGroups();
    }

    @Override
    public Integer findOwnerGroupId(String wxAppId, String openId) {
        return execToken(wxAppId,new FindOwnerGroupIdCmd(openId)).getGroupId();
    }

    @Override
    public Boolean modifyGroupName(String wxAppId, Integer groupId, String groupName) {
        execToken(wxAppId, new ModifyGroupNameCmd(groupId, groupName));
        return true;
    }

    @Override
    public Boolean userChangeGroup(String wxAppId, Integer groupId, String openId) {
        execToken(wxAppId,new UserChangeGroup(openId,groupId));
        return true;
    }
}
