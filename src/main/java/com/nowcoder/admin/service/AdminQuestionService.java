package com.nowcoder.admin.service;

import com.nowcoder.admin.dao.AdminQuestionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/5/7
 * @Time 23:07
 */
@Service
public class AdminQuestionService {
    private static final Logger logger = LoggerFactory.getLogger(AdminQuestionService.class);

    @Autowired
    AdminQuestionDAO adminQuestionDAO;

    public void closeQuestion(int id) {
        adminQuestionDAO.deleteQuestion(id);
    }

    public int countQuestion() {
        return adminQuestionDAO.selectCountQuestion();
    }
}
