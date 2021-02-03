package com.redash.controller;


import com.redash.framework.object.PageResult;
import com.redash.queryvo.UserConditionVO;
import com.redash.service.UserService;
import com.redash.vo.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 */
@Component
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/username/{id}")
    public UserVO getUserName(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    @ResponseBody
    public UserVO add(@RequestParam("name") String name, @RequestParam("email") String email) {
        return userService.addUser(name, email);
    }

    @PostMapping("/users/{id}")
    @ResponseBody
    public UserVO update(@PathVariable Long id, @RequestParam("name") String name,
                         @RequestParam("email") String email, @RequestParam("group_ids") Integer[] group_ids) {
        return userService.update(id, name, email, group_ids);
    }

    @PostMapping("/users/{id}/disable")
    @ResponseBody
    public UserVO disabled(@PathVariable Long id) {
        return userService.disabled(id);
    }

    @PostMapping("/users/{id}/regenerate_api_key")
    @ResponseBody
    public UserVO regenerateApiKey(@PathVariable Long id) {
        return userService.regenerateApiKey(id);
    }

    @GetMapping("/users")
    @ResponseBody
    public PageResult userList(UserConditionVO vo){
        PageResult result = userService.listUser(vo);
        return result;
    }

    @PostMapping("/users/{id}/disable")
    @ResponseBody
    public void disabled(@PathVariable String id){

    }
}
