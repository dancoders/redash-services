package com.dancoder.redash.service;

import com.dancoder.redash.api.UserService;
import com.dancoder.redash.api.model.UserModel;
import com.dancoder.redash.business.vo.UserConditionVO;
import com.dancoder.redash.dao.dataobject.UserDO;
import com.dancoder.redash.dao.mapper.UserMapper;
import com.dancoder.redash.framework.exception.RedashException;
import com.dancoder.redash.framework.object.PageResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static final BeanCopier COPIER = BeanCopier.create(UserModel.class, UserDO.class, false);

    private static final BeanCopier COPIER2 = BeanCopier.create(UserDO.class, UserModel.class, false);

    private static final String emailSymbol = "@";

    private static final String qqEmailDoMain = "qq.com";

    @Override
    public String getUserName(Long id) {
        UserDO userDO = userMapper.getById(id);
        return userDO != null ? userDO.getName() : null;
    }

    @Override
    public UserModel addUser(UserModel user) {
        String email = user.getEmail();
        if (! email.contains(emailSymbol)) {
            throw new RedashException("bad email address.");
        }

        String[] address = email.split(emailSymbol, 1);

        if (address[1].toLowerCase() == qqEmailDoMain) {
            throw new RedashException("bad email address.");
        }

        UserDO userDO = new UserDO();
        COPIER.copy(user, userDO, null);

        userDO.setOrgId(1L);
        userDO.setGroups("{2}");
        userDO.setApiKey("");
        userDO.setDetails("{\"is_invitation_pending\": true}");
        Long id = userMapper.insert(userDO);

        user.setId(id);
        return user;
    }

    @Override
    public UserModel getUserById(Long id) {
        UserDO userDO = userMapper.getById(id);
        UserModel userModel = new UserModel();
        COPIER2.copy(userDO, userModel, null);
        return userModel;
    }

    @Override
    public PageResult listUser(UserConditionVO vo) {
        PageHelper.startPage(vo.getPage(), vo.getPageSize());
        List<UserDO> list = userMapper.findUsersByCondition(vo);
        List<UserModel> resultList = geProperties(list);
        if (null == resultList) {
            return null;
        }

        PageResult pageResult = new PageResult(
                resultList.size(),
                vo.getPage(),
                vo.getPageSize(),
                resultList
        );
        return pageResult;
    }

    private List<UserModel> geProperties(List<UserDO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        List<UserModel> resultList = new LinkedList<>();
        for (UserDO user : list) {
            UserModel userModel = new UserModel();
            COPIER2.copy(user,userModel,null);
            resultList.add(userModel);
        }
        return resultList;
    }

}
