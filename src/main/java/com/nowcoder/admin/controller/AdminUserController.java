package com.nowcoder.admin.controller;

import com.nowcoder.admin.service.AdminUserService;
import com.nowcoder.model.User;
import com.nowcoder.model.ViewObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;

    @RequestMapping(path = "/close_users", method = RequestMethod.GET)
    public String closeUser(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminUserService.closeUser(id);
        }
        return "redirect:/listuser";
    }

    @RequestMapping(path = "/close_user", method = RequestMethod.GET)
    public String closeUser(@RequestParam("id") int id) {
        adminUserService.closeUser(id);
        return "redirect:/listuser";
    }

    @RequestMapping(path = "/open_users", method = RequestMethod.GET)
    public String openUsers(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminUserService.openUser(id);
        }
        return "redirect:/listuser";
    }

    @RequestMapping(path = "/open_user", method = RequestMethod.GET)
    public String openUser(@RequestParam("id") int id) {
        adminUserService.openUser(id);
        return "redirect:/listuser";
    }

    @RequestMapping(path = "/del_users", method = RequestMethod.GET)
    public String delUsers(@RequestParam("ids") int[] ids) {
        for (int id : ids) {
            adminUserService.delUser(id);
        }
        return "redirect:/listuser";
    }

    @RequestMapping(path = "/del_user", method = RequestMethod.GET)
    public String delUser(@RequestParam("id") int id) {
        adminUserService.delUser(id);
        return "redirect:/listuser";
    }

    @RequestMapping(path = "/listuser", method = RequestMethod.GET)
    public String listUser(Model model) {
        List<User> userList = adminUserService.listUser();
        List<ViewObject> vos = new ArrayList<>();
        for (User user : userList) {
            ViewObject vo = new ViewObject();
            vo.set("user", user);
            vos.add(vo);
        }
        model.addAttribute("vos", vos);
        return "list_user_pages";
    }
}
