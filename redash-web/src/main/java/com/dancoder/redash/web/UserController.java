package com.dancoder.redash.web;

import com.dancoder.redash.api.UserService;
import com.dancoder.redash.api.model.UserModel;
import com.dancoder.redash.business.vo.UserConditionVO;
import com.dancoder.redash.framework.object.PageResult;
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
    public UserModel getUserName(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/users")
    @ResponseBody
    public UserModel addUser(@RequestParam("name") String name, @RequestParam("email") String email) {
        UserModel user = new UserModel();
        user.setName(name);
        user.setEmail(email);
        return userService.addUser(user);
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
