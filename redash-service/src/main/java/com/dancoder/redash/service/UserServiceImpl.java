package com.dancoder.redash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;

import com.dancoder.redash.dao.dataobject.UserDO;
import com.dancoder.redash.dao.mapper.UserMapper;
import com.dancoder.redash.api.UserService;
import com.dancoder.redash.api.model.UserModel;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static final BeanCopier copier = BeanCopier.create(UserModel.class, UserDO.class, false);

    private static final BeanCopier copier2 = BeanCopier.create(UserDO.class, UserModel.class, false);

    public String getUserName(Long id) {
        UserDO userDO = userMapper.getById(id);
        return userDO != null ? userDO.getName() : null;
    }

    public UserModel addUser(UserModel user) {
        UserDO userDO = new UserDO();
        copier.copy(user, userDO, null);

        Long id = userMapper.insert(userDO);
        user.setId(id);
        return user;
    }

    @Override
    public UserModel getUserById(Long id) {
        UserDO userDO = userMapper.getById(id);
        UserModel userModel = new UserModel();
        copier2.copy(userDO, userModel, null);
        return userModel;
    }

}
