package com.nowcoder.service;

import com.nowcoder.dao.QuestionDAO;
import com.nowcoder.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

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

    @Autowired
    SensitiveService sensitiveService;

    public int addQuestion(Question question) {
        /**
         * 使用html工具类过滤掉html标签
         * 对html标签实现转译
         *         敏感词过滤
         */
        question.setContent(HtmlUtils.htmlEscape(question.getContent()));
        question.setTitle(HtmlUtils.htmlEscape(question.getTitle()));
        question.setTitle(sensitiveService.filter(question.getTitle()));
        question.setContent(sensitiveService.filter(question.getContent()));
        return questionDAO.addQuestion(question) > 0 ? question.getId() : 0;
    }
    public List<Question> getLatestQuestion(int userId, int offset, int limit) {
        return questionDAO.selectLatestQuestions(userId, offset, limit);
    }

    public List<Question> selectQuestions() {
        return questionDAO.selectQuestions();
    }

    public Question selectById(int id) {
        return questionDAO.selectById(id);
    }

    public void updateCommentCount(int count, int id) {
        questionDAO.updateCommentCount(count, id);
    }

    public int getQuestionNum() {
        return questionDAO.getQuestionNum();
    }
}
