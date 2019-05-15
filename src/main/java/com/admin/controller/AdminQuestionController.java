package com.admin.controller;

import com.admin.service.AdminQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminQuestionController {
    @Autowired
    AdminQuestionService adminQuestionService;

    @RequestMapping(path = "close_question", method = RequestMethod.POST)
    public String closeQuestion(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminQuestionService.closeQuestion(id);
        }
        return "";
    }
}
