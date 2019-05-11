package com.admin.controller;

import com.admin.model.Root;
import com.admin.service.AdminLoginService;
import com.nowcoder.controller.LoginController;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import java.util.Map;

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

    @RequestMapping(path = "/rootlogin", method = RequestMethod.POST)
    public String rootLogin(Model model, @RequestParam("username") String username) {
//                            @RequestParam("passord") String password) {
//        Root root = adminLoginService.getRootByName(username);
//        if (root.getPassword().equals(password)) {
//            return ""
//        }
        return "admin-login";
    }


}
