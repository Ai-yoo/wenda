package com.nowcoder.admin.service;

import com.nowcoder.admin.dao.AdminUserDAO;
import com.nowcoder.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void openUser(int id) {
        adminUserDAO.updateUserState0(id);
    }

    public int countUser() {
        return adminUserDAO.selectCountUser();
    }

    public List<User> listUser() {
        return adminUserDAO.selectUsers();
    }

    public void delUser(int id) {
        adminUserDAO.deleteUser(id);
    }

}
