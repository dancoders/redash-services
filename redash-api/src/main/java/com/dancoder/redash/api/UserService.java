package com.dancoder.redash.api;


import com.baomidou.mybatisplus.extension.service.IService;
import com.dancoder.redash.api.model.UserModel;
import com.dancoder.redash.business.vo.UserConditionVO;
import com.dancoder.redash.dao.entity.UserDO;
import com.dancoder.redash.framework.object.PageResult;

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
    UserModel addUser(String name, String email);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    UserModel getUserById(Long id);

    /**
     * 获取用户列表
     * @param vo
     * @return
     */
    PageResult listUser(UserConditionVO vo);
}
