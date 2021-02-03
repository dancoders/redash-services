package com.redash.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.dynamic.datasource.annotation.Master;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.redash.dto.GroupDTO;
import com.redash.dto.UserDTO;
import com.redash.entity.GroupDO;
import com.redash.entity.UserDO;
import com.redash.framework.exception.RedashBadRequestException;
import com.redash.framework.object.PageResult;
import com.redash.mapper.GroupMapper;
import com.redash.mapper.UserMapper;
import com.redash.queryvo.UserConditionVO;
import com.redash.service.UserService;
import com.redash.vo.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author dancoder
 */
@Master
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final GroupMapper groupMapper;

    public UserServiceImpl(GroupMapper groupMapper){
        this.groupMapper = groupMapper;
    }

    private static final String emailSymbol = "@";
    private static final String qqEmailDoMain = "qq.com";

    @Override
    public boolean login(String email, String password) {
        UserDO user = baseMapper.getByEmail(email);
        if (null == user) {
            throw new RedashBadRequestException(404, "账号不存在");
        }

        String pass = DigestUtil.md5Hex("yc" + user.getName());
        if (pass.equals(user.getPasswordHash())) {
            // 写入session

        } else {
            throw new RedashBadRequestException(400, "密码错误");
        }
        return true;
    }

    @Override
    public String getUserName(Long id) {
        UserDO userDO = baseMapper.selectById(id);
        return userDO != null ? userDO.getName() : null;
    }

    @Override
    public UserVO addUser(String name, String email) {
        UserDO user = baseMapper.getByEmail(email);
        if (null != user) {
            throw new RedashBadRequestException(400, "email already exists");
        }

        UserVO userVO = new UserVO();
        if (! email.contains(emailSymbol)) {
            throw new RedashBadRequestException(400, "bad email address.");
        }

        String[] address = email.split(emailSymbol, 1);

        if (address[0].toLowerCase() == qqEmailDoMain) {
            throw new RedashBadRequestException(400, "bad email address.");
        }

        // 默认生成密码：yc + 用户名
        String pass = DigestUtil.bcrypt("yc" + name);
        String apiKey = RandomUtil.randomString(40);

        UserDO userDO = new UserDO();
        userDO.setName(name);
        userDO.setEmail(email);
        userDO.setProfileImageUrl(
                String.format("https://www.gravatar.com/avatar/%s?s=40&d=identicon", DigestUtil.md5Hex(email.toLowerCase())));

        userDO.setPasswordHash(pass);
        userDO.setOrgId(1L);
        userDO.setApiKey(apiKey);
        // TODO 新增用户加入默认group，后期是否需要动态加载
        userDO.setGroups(new Integer[]{2});

        baseMapper.insert(userDO);
        BeanUtil.copyProperties(userDO, userVO);
        buildUserVO(userVO);
        return userVO;
    }

    private void buildUserVO(UserVO userVO) {
        if (StringUtils.isNotBlank(userVO.getPasswordHash())) {
            userVO.setAuthType("password");
            userVO.setPasswordHash("---");
        }
        if (StringUtils.checkValNull(userVO.getDisabledAt())) {
            userVO.setIsDisabled(false);
        } else {
            userVO.setIsDisabled(true);
        }
    }

    @Override
    public UserVO getUserById(Long id) {
        UserDO user = getById(id);
        if (null == user) {
            throw new RedashBadRequestException(404, "账号不存在");
        }
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(user, userVO);
        buildUserVO(userVO);
        return userVO;
    }

    @Override
    public PageResult listUser(UserConditionVO vo) {
        PageHelper.startPage(vo.getPage(), vo.getPageSize());
        List<UserDO> list = baseMapper.findUsersByCondition(vo);
        List<UserDTO> userList = geProperties(list);
        if (null == userList) {
            return null;
        }
        PageResult pageResult = new PageResult(
                userList.size(),
                vo.getPage(),
                vo.getPageSize(),
                userList
        );
        return pageResult;
    }

    private UserDO getById(Long id) {
        return baseMapper.getById(id);
    }

    @Override
    public UserVO regenerateApiKey(Long id) {
        UserVO userVO = new UserVO();
        String apiKey = RandomUtil.randomString(40);
        UserDO userDO = new UserDO();
        userDO.setId(id);
        userDO.setApiKey(apiKey);
        baseMapper.updateById(userDO);

        userDO = getById(id);
        BeanUtil.copyProperties(userDO, userVO);
        return userVO;
    }

    @Override
    public UserVO update(Long id, String name, String email, Integer[] group_ids) {
        UserDO user = getById(id);
        if (null == user) {
            throw new RedashBadRequestException(404, "账号不存在");
        }
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setGroups(group_ids);

        baseMapper.updateById(user);
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(getById(id), userVO);
        return userVO;
    }

    @Override
    public UserVO disabled(Long id) {
        UserDO user = getById(id);
        if (null == user) {
            throw new RedashBadRequestException(404, "账号不存在");
        }

        user.setId(id);

        if (StringUtils.checkValNull(user.getDisabledAt())) {
            // 禁用
            user.setDisabledAt(new Date());
        } else {
            // 启用
            user.setDisabledAt(null);
        }

        baseMapper.updateById(user);
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(getById(id), userVO);

        buildUserVO(userVO);
        return userVO;
    }

    private List<UserDTO> geProperties(List<UserDO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        Map<Integer, GroupDTO> groups = transGroups(groupMapper.getAll());

        List<UserDTO> resultList = new LinkedList<>();
        for (UserDO user : list) {
            UserDTO userDTO = new UserDTO();

            BeanUtil.copyProperties(user, userDTO);

            Integer[] userGroups = user.getGroups();
            List<GroupDTO> groupDTOS = new ArrayList<>();
            for (Integer group : userGroups) {
                groupDTOS.add(groups.get(group));
            }
            userDTO.setGroups(groupDTOS);
            resultList.add(userDTO);
        }
        return resultList;
    }

    private Map<Integer, GroupDTO> transGroups(List<GroupDO> groups) {
        Map<Integer, GroupDTO> resultMap = new HashMap<>(10);
        for (GroupDO group : groups) {
            GroupDTO groupDTO = new GroupDTO();
            BeanUtil.copyProperties(group, groupDTO);
            resultMap.put(group.getId().intValue(), groupDTO);
        }
        return resultMap;
    }

}
