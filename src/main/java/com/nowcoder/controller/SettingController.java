package com.nowcoder.controller;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventProducer;
import com.nowcoder.async.EventType;
import com.nowcoder.dao.UserDAO;
import com.nowcoder.model.User;
import com.nowcoder.service.UserService;
import com.nowcoder.service.WendaService;
import com.nowcoder.util.WendaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/7
 * @Time 17:04
 */
@Controller
public class SettingController {

    @Autowired
    WendaService wendaService;

    @Autowired
    UserService userService;

    @Autowired
    UserDAO userDAO;

    @Autowired
    EventProducer eventProducer;


    @RequestMapping(path = {"/setting"}, method = {RequestMethod.GET})
    @ResponseBody
    public String setting(HttpSession httpSession) {
        return "Setting OK" + wendaService.getMessage(1);

    }

    @RequestMapping(path = {"/sendmsg"}, method = {RequestMethod.POST})
    @ResponseBody
    public String sendMsg(@RequestParam("username") String username, HttpSession session) {
        String msg = WendaUtil.getRanString();
        session.setAttribute("captcha", msg);
        session.setAttribute("username", username);
        eventProducer.fireEvent(new EventModel(EventType.FIND_PASSWORD)
                .setExt("username", username).setExt("email", username).setExt("msg", msg));
        return WendaUtil.getJSONString(200);
    }

    @RequestMapping(path = {"/password_reset"}, method = {RequestMethod.POST})
    public String findPassword(@RequestParam("captcha") String captcha, HttpSession session) {
        String msg = session.getAttribute("captcha").toString();
        if (captcha.equals(msg)) {
            return "passwordReset";
        }
        return "findPassword";
    }

    @RequestMapping(path = {"/setpass"}, method = {RequestMethod.POST})
    public String setPass(@RequestParam("password") String password, HttpSession session) {
        String username = session.getAttribute("username").toString();
        System.out.println("密码是"+password);
        User user = userDAO.selectByName(username);
        System.out.println(user.toString());
        user.setSalt(UUID.randomUUID().toString().substring(0, 5));
        user.setPassword(WendaUtil.MD5(password + user.getSalt()));
        System.out.println(user.toString());
        userDAO.updatePassword(user);
        return "login";
    }

}
