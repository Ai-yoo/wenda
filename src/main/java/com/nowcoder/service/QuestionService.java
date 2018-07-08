package com.nowcoder.service;

import com.nowcoder.dao.QuestionDAO;
import com.nowcoder.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/8
 * @Time 18:03
 */
@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getLatestQuestion(int userId, int offset, int limit) {
        return questionDAO.selectLatestQuestions(userId, offset, limit);
    }
}
