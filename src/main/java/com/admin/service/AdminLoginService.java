package com.admin.service;

import com.admin.dao.AdminLoginDAO;
import com.admin.model.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/5/5
 * @Time 23:29
 */
@Service
public class AdminLoginService {
    private static final Logger logger = LoggerFactory.getLogger(AdminLoginService.class);

    @Autowired
    private AdminLoginDAO adminLoginDAO;

    public Root login(String username,String password) {
        return adminLoginDAO.selectByName(username);
    }

    public Root getRootByName(String name) {
        return adminLoginDAO.selectByName(name);
    }


}
