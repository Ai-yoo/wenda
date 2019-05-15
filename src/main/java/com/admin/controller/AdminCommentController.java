package com.admin.controller;

import com.admin.service.AdminCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminCommentController {
    @Autowired
    AdminCommentService adminCommentService;

    @RequestMapping(path = "/close_comment", method = RequestMethod.POST)
    public String closeComment(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminCommentService.closeComment(id);
        }
        return "";
    }
}
