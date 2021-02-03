package com.redash.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.redash.dto.GroupDTO;
import com.redash.entity.GroupDO;

import java.util.List;

/**
 * @author dancoder
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 获取全部group
     * @return
     */
    List<GroupDTO> getAll();
}
