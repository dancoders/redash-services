package com.dancoder.redash.api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dancoder.redash.api.model.GroupModel;
import com.dancoder.redash.dao.entity.GroupDO;

import java.util.List;

/**
 * @author dancoder
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 获取全部group
     * @return
     */
    List<GroupModel> getAll();
}
