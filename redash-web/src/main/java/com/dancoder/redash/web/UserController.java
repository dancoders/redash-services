package com.dancoder.redash.web;

import com.dancoder.redash.api.UserService;
import com.dancoder.redash.api.model.UserModel;
import com.dancoder.redash.api.vo.UserVO;
import com.dancoder.redash.business.vo.UserConditionVO;
import com.dancoder.redash.framework.object.PageResult;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
@RestController
public class UserController {

    @Autowired
    private UserService userService;

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
