package com.dancoder.redash.web;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dancoder
 */
@Component
@RestController
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public void login(@RequestParam("email") String email, @RequestParam("password") String password){

    }
}
