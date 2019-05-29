package com.nowcoder.admin.controller;

import com.nowcoder.admin.service.*;
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

    @Autowired
    AdminCommentService adminCommentService;

    @Autowired
    AdminQuestionService adminQuestionService;

    @Autowired
    AdminUserService adminUserService;

    @Autowired
    AdminMessageService adminMessageService;

    @RequestMapping(path = {"/root_login"}, method = {RequestMethod.POST})
    public String rootLogin(Model model, @RequestParam("username") String username,
                            @RequestParam("password") String password) {
        if (adminLoginService.login(username, password)) {
            int user_num = adminUserService.countUser();
            int comment_num = adminCommentService.countComment();
            int question_num = adminQuestionService.countQuestion();
            int message_num = adminMessageService.countMessage();
            model.addAttribute("userNum", user_num);
            model.addAttribute("comNum", comment_num);
            model.addAttribute("quesNum", question_num);
            model.addAttribute("messNum", message_num);
            model.addAttribute("name", username);
            return "admin-index";
        }
        return "lyear_pages_login";
    }

    @RequestMapping(path = {"/admin"}, method = {RequestMethod.GET})
    public String index() {
        return "lyear_pages_login";
    }

    @RequestMapping(path = "root_logout", method = RequestMethod.GET)
    public String rootLogout() {
        return "lyear_pages_login";
    }

}
