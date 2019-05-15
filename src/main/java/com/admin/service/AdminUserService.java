package com.admin.service;

import com.admin.dao.AdminUserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/5/7
 * @Time 22:58
 */
@Service
public class AdminUserService {
    private static final Logger logger = LoggerFactory.getLogger(AdminUserService.class);

    @Autowired
    private AdminUserDAO adminUserDAO;

    public void closeUser(int id) {
        adminUserDAO.updateUserState(id);
    }

}
