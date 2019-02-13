package com.nowcoder.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nowcoder.aspect.LogAspect;
import com.nowcoder.model.*;
import com.nowcoder.service.CommentService;
import com.nowcoder.service.FollowService;
import com.nowcoder.service.QuestionService;
import com.nowcoder.service.UserService;
import com.nowcoder.util.PageUtil;
import org.apache.http.HttpRequest;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/8
 * @Time 11:30
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @Autowired
    FollowService followService;

    @Autowired
    CommentService commentService;

    @Autowired
    HostHolder hostHolder;

    @RequestMapping(path = {"/user/{userId}"}, method = {RequestMethod.GET})
    public String userIndex(Model model, @PathVariable("userId") int userId) {
        model.addAttribute("vos", getQuestions(userId, 0, 10));

        User user = userService.getUser(userId);
        ViewObject vo = new ViewObject();
        vo.set("user", user);
        vo.set("commentCount", commentService.getCommentCount(userId, EntityType.ENTITY_COMMENT));
        vo.set("followerCount", followService.getFollowerCount(EntityType.ENTITY_USER, userId));
        vo.set("followeeCount", followService.getFolloweeCount(userId, EntityType.ENTITY_USER));
        if (hostHolder.getUser() != null) {
            vo.set("followed", followService.isFollower(hostHolder.getUser().getId(), EntityType.ENTITY_USER, userId));
        } else {
            vo.set("followed", false);
        }
        model.addAttribute("profileUser", vo);
        return "profile";
    }

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET})
    public String index(@RequestParam(required = false, defaultValue = "1", value = "currentPage") Integer currentPage,
                        @RequestParam(required = false, defaultValue = "0", value = "userId") Integer userId,
                        Model model, HttpServletRequest request) {
        PageUtil page = splitPage();
        //总页数
        int totalPage = page.getTotalPage();
        model.addAttribute("totalPage", totalPage);

        //总条数
        int totalQuestion = questionService.getQuestionNum();
        model.addAttribute("totalQuestionNum", totalQuestion);

        //当前页
        if (currentPage <= 0) {
            currentPage = 1;
        } else if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("p", currentPage);

        int per = currentPage - 2;
        int next = currentPage + 2;
        if (per <= 0) {
            per = 1;
        } else if (next > totalPage) {
            next = totalPage;
        }
        List<Integer> pageList = new ArrayList();
        for (int i = per; i <= next; i++) {
            pageList.add(i);
        }
        model.addAttribute("pageList", pageList);

        model.addAttribute("url", request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort());
        model.addAttribute("vos", getQuestions(userId, currentPage, page.getPageSize()));
        return "index";
    }

    private List<ViewObject> getQuestions(int userId, int offset, int limit) {
        List<Question> questionList = questionService.getLatestQuestion(userId, offset,limit);
        List<ViewObject> vos = new ArrayList<>();
        for (Question question : questionList) {
            ViewObject vo = new ViewObject();
            vo.set("question", question);
            vo.set("user", userService.getUser(question.getUserId()));
            vos.add(vo);
        }
        return vos;
    }

//    private List<ViewObject> getQuestions() {
//        List<Question> questionList = questionService.selectQuestions();
//        List<ViewObject> vos = new ArrayList<>();
//        for (Question question : questionList) {
//            ViewObject vo = new ViewObject();
//            vo.set("question", question);
//            vo.set("user", userService.getUser(question.getUserId()));
//            vos.add(vo);
//        }
//        return vos;
//    }


    private PageUtil splitPage() {
        PageUtil page = new PageUtil();
        int totalQuestion = questionService.getQuestionNum();
        int pageSize = page.getPageSize();
        page.setTotalPage((totalQuestion % pageSize == 0) ? totalQuestion / pageSize : totalQuestion / pageSize + 1);
        return page;
    }

}
