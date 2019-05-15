package com.admin.service;

import com.admin.dao.AdminLoginDAO;
import com.admin.model.Root;
import org.apache.commons.lang.StringUtils;
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

    public boolean login(String username,String password) {
        if (StringUtils.isBlank(username)) {
            return false;
        }
        if (StringUtils.isBlank(password)) {
            return false;
        }
        Root root = adminLoginDAO.selectByName(username);
        if (root.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public Root getRootByName(String name) {
        return adminLoginDAO.selectByName(name);
    }


}
