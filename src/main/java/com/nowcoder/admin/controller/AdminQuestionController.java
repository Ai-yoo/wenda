package com.nowcoder.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nowcoder.admin.service.AdminQuestionService;
import com.nowcoder.model.Question;
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
public class AdminQuestionController {
    @Autowired
    AdminQuestionService adminQuestionService;

    @RequestMapping(path = "close_questions", method = RequestMethod.GET)
    public String closeQuestions(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminQuestionService.closeQuestion(id);
        }
        return "list_question_pages";
    }

    @RequestMapping(path = "close_question", method = RequestMethod.GET)
    public String closeQuestion(@RequestParam("id") int id) {
        adminQuestionService.closeQuestion(id);
        return "list_question_pages";
    }

    @RequestMapping(path = "open_questions", method = RequestMethod.GET)
    public String openQuestions(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminQuestionService.openQuestion(id);
        }
        return "list_question_pages";
    }

    @RequestMapping(path = "open_question", method = RequestMethod.GET)
    public String openQuestion(@RequestParam("id") int id) {
        adminQuestionService.openQuestion(id);
        return "list_question_pages";
    }

    @RequestMapping(path = "del_questions", method = RequestMethod.GET)
    public String delQuestions(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminQuestionService.delQuestion(id);
        }
        return "list_question_pages";
    }

    @RequestMapping(path = "del_question", method = RequestMethod.GET)
    public String delQuestion(@RequestParam("id") int id) {
        adminQuestionService.delQuestion(id);
        return "list_question_pages";
    }

    @RequestMapping(path = "/listquestion", method = RequestMethod.GET)
    public String listUser(HttpSession session, Model model, @RequestParam(defaultValue = "1",value = "pn") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Question> questionList = adminQuestionService.listQuestion();
        PageInfo pageInfo = new PageInfo(questionList);
        List<ViewObject> vos = new ArrayList<>();
        for (Question question : questionList) {
            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vos.add(vo);
        }
        model.addAttribute("vos", vos);
        model.addAttribute("pageInfo", pageInfo);
        if (session.getAttribute("name") == null) {
            return "lyear_pages_login";
        } else {
            return "list_question_pages";
        }
    }
}
