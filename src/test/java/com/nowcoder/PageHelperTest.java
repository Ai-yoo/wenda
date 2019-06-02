package com.nowcoder;

import com.github.pagehelper.PageHelper;
import com.nowcoder.admin.dao.AdminUserDAO;
import com.nowcoder.admin.service.AdminUserService;
import com.nowcoder.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/6/2
 * @Time 22:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WendaApplication.class)
public class PageHelperTest {

    @Autowired
    AdminUserDAO adminUserDAO;

    @Test
    public void getUsers() {
        PageHelper.startPage(1, 10);
        System.out.println(adminUserDAO.selectUsers().toString());
    }
}
