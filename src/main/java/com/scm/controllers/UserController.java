package com.scm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

//    user dashboard page
    @RequestMapping(value = "/dashboard")
    public String userDashboard(){
        System.out.println("User dashbaord....!!");
        return "user/dashboard";
    }
//    user profile page

    @RequestMapping(value = "/profile")
    public String userProfiled(){
        System.out.println("User profile....!!");
        return "user/profile";
    }
//    user add contacts page
//    user view contacts page
//    user edit contacts page
//    user delete contact page
//    user search contacts page
}
