package com.dancoder.redash.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.dancoder.redash.api.UserService;
import com.dancoder.redash.api.model.UserModel;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Component
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/username/{id}")
    public UserModel getUserName(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/add")
    @ResponseBody
    public UserModel addUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        UserModel user = new UserModel();
        user.setName(name);
        return userService.addUser(user);
    }
}
