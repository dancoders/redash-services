package com.redash.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.redash.entity.UserDO;
import com.redash.framework.object.PageResult;
import com.redash.queryvo.UserConditionVO;
import com.redash.vo.UserVO;

/**
 * @author dancoder
 */
public interface UserService extends IService<UserDO> {

    /**
     * 登陆验证
     * @param email
     * @param password
     * @return
     */
    boolean login(String email,String password);

    /**
     * 根据name查用户
     * @param id
     * @return
     */
    String getUserName(Long id);

    /**
     * 增加用户
     * @param name
     * @param email
     * @return
     */
    UserVO addUser(String name, String email);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    UserVO getUserById(Long id);

    /**
     * 获取用户列表
     * @param vo
     * @return
     */
    PageResult listUser(UserConditionVO vo);

    /**
     * 重置apiKey
     * @param id
     * @return
     */
    UserVO regenerateApiKey(Long id);

    /**
     * 更新user
     * @param id
     * @param name
     * @param email
     * @param group_ids
     * @return
     */
    UserVO update(Long id, String name, String email, Integer[] group_ids);

    /**
     * 禁用用户
     * @param id
     * @return
     */
    UserVO disabled(Long id);
}
