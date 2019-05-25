package com.nowcoder.admin.controller;

import com.nowcoder.admin.service.AdminLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/5/5
 * @Time 23:30
 */
@Controller
public class AdminLoginController {
    private static final Logger logger = LoggerFactory.getLogger(AdminLoginController.class);

    @Autowired
    AdminLoginService adminLoginService;

    @RequestMapping(path = {"/root_login"}, method = {RequestMethod.GET})
    public String rootLogin(Model model, @RequestParam("username") String username,
                            @RequestParam("password") String password) {
        if (adminLoginService.login(username, password)) {
            return "admin-index";
        }
        return "admin-login";
    }

    @RequestMapping(path = "root_logout", method = RequestMethod.GET)
    public String rootLogout() {
        return "admin-index";
    }

}