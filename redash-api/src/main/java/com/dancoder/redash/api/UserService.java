package com.dancoder.redash.api;


import com.dancoder.redash.api.model.UserModel;

import java.util.List;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserService {

    String getUserName(Long id);

    UserModel addUser(UserModel user);

    UserModel getUserById(Long id);
}
