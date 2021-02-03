package com.redash.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.dynamic.datasource.annotation.Master;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.redash.dto.GroupDTO;
import com.redash.entity.GroupDO;
import com.redash.mapper.GroupMapper;
import com.redash.service.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dancoder
 */
@Master
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    @Override
    public List<GroupDTO> getAll() {
        List<GroupDO> list = baseMapper.getAll();
        List<GroupDTO> groupList = geProperties(list);
        return groupList;
    }

    private List<GroupDTO> geProperties(List<GroupDO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<GroupDTO> resultList = new LinkedList<>();
        for (GroupDO groupDO : list) {
            GroupDTO groupModel = new GroupDTO();
            BeanUtil.copyProperties(groupDO, groupModel);
            resultList.add(groupModel);
        }
        return resultList;
    }
}
