package com.redash.controller;


import com.redash.dto.GroupDTO;
import com.redash.queryvo.UserConditionVO;
import com.redash.service.GroupService;
import com.redash.vo.UserVO;
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
    public GroupDTO addUser(@RequestParam("name") String name, @RequestParam("email") String email) {
        return null;
    }

    @GetMapping("/groups")
    @ResponseBody
    public List<GroupDTO> userList(UserConditionVO vo){
        List<GroupDTO> list = groupService.getAll();
        return list;
    }
}
