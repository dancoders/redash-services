package com.dancoder.redash.web;

import com.dancoder.redash.api.GroupService;
import com.dancoder.redash.api.model.GroupModel;
import com.dancoder.redash.api.vo.UserVO;
import com.dancoder.redash.business.vo.UserConditionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dancoder
 */
@Component
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping("/groups/{id}")
    public UserVO getUserName(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/groups")
    @ResponseBody
    public GroupModel addUser(@RequestParam("name") String name, @RequestParam("email") String email) {
        return null;
    }

    @GetMapping("/groups")
    @ResponseBody
    public List<GroupModel> userList(UserConditionVO vo){
        List<GroupModel> list = groupService.getAll();
        return list;
    }
}
