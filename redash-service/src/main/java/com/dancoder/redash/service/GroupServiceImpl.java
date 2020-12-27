package com.dancoder.redash.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.dynamic.datasource.annotation.Master;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dancoder.redash.api.GroupService;
import com.dancoder.redash.api.model.GroupModel;
import com.dancoder.redash.api.model.UserModel;
import com.dancoder.redash.dao.entity.GroupDO;
import com.dancoder.redash.dao.entity.UserDO;
import com.dancoder.redash.dao.mapper.GroupMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author dancoder
 */
@Master
@Component
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    @Override
    public List<GroupModel> getAll() {
        List<GroupDO> list = baseMapper.getAll();
        List<GroupModel> groupList = geProperties(list);
        return groupList;
    }

    private List<GroupModel> geProperties(List<GroupDO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<GroupModel> resultList = new LinkedList<>();
        for (GroupDO groupDO : list) {
            GroupModel groupModel = new GroupModel();
            BeanUtil.copyProperties(groupDO, groupModel);
            resultList.add(groupModel);
        }
        return resultList;
    }
}
