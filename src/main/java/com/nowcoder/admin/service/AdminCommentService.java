package com.nowcoder.admin.service;

import com.nowcoder.admin.dao.AdminMessageDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/5/7
 * @Time 23:11
 */
@Service
public class AdminCommentService {
    private static final Logger logger = LoggerFactory.getLogger(AdminCommentService.class);

    @Autowired
    private AdminMessageDAO adminMessageDAO;

    public void closeComment(int id) {
        adminMessageDAO.updateMessageState(id);
    }
}
