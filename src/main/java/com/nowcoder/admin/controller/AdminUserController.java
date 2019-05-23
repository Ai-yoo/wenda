package com.nowcoder.admin.controller;

import com.nowcoder.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;
//    @Autowired
//    UserService userService;

    @RequestMapping(path = "close_user", method = RequestMethod.POST)
    public String closeUser(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminUserService.closeUser(id);
        }
        return "";
    }

//    @RequestMapping(path = "add_user", method = RequestMethod.POST)
//    public void addUser(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        @RequestParam("email") String email) {
//        userService.register(username, email, password, 0);
//    }
}
