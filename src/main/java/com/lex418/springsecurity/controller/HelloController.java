package com.lex418.springsecurity.controller;

import com.lex418.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

//    @PostMapping("/user")
//    public String  createUser(@RequestBody User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        jdbcUserDetailsManager.createUser(user);
//        return "user successfully created";
//    }
}
