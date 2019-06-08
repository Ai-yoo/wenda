package com.nowcoder.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nowcoder.admin.service.AdminCommentService;
import com.nowcoder.model.Comment;
import com.nowcoder.model.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminCommentController {
    @Autowired
    AdminCommentService adminCommentService;

    @RequestMapping(path = "close_comments", method = RequestMethod.GET)
    public String closeComments(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminCommentService.closeComment(id);
        }
        return "list_comment_pages";
    }

    @RequestMapping(path = "close_comment", method = RequestMethod.GET)
    public String closeComment(@RequestParam("id") int id) {
        adminCommentService.closeComment(id);
        return "list_comment_pages";
    }

    @RequestMapping(path = "open_comments", method = RequestMethod.GET)
    public String openComments(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminCommentService.openComment(id);
        }
        return "list_comment_pages";
    }

    @RequestMapping(path = "open_comment", method = RequestMethod.GET)
    public String openComment(@RequestParam("id") int id) {
        adminCommentService.openComment(id);
        return "list_comment_pages";
    }

    @RequestMapping(path = "del_comments", method = RequestMethod.GET)
    public String delComments(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminCommentService.delComment(id);
        }
        return "list_comment_pages";
    }

    @RequestMapping(path = "del_comment", method = RequestMethod.GET)
    public String delComment(@RequestParam("id") int id) {
        adminCommentService.delComment(id);
        return "list_comment_pages";
    }

    @RequestMapping(path = "/listcomment", method = RequestMethod.GET)
    public String listUser(HttpSession session, Model model, @RequestParam(defaultValue = "1", value = "pn") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Comment> commentList = adminCommentService.listComment();
        PageInfo pageInfo = new PageInfo(commentList);
        List<ViewObject> vos = new ArrayList<>();
        for (Comment comment : commentList) {
            ViewObject vo = new ViewObject();
            vo.set("comment", comment);
            vos.add(vo);
        }
        model.addAttribute("vos", vos);
        model.addAttribute("pageInfo", pageInfo);
        if (session.getAttribute("name") == null) {
            return "lyear_pages_login";
        } else {
            return "list_comment_pages";
        }
    }
}
