package com.nowcoder.admin.service;

import com.nowcoder.admin.dao.AdminCommentDAO;
import com.nowcoder.admin.dao.AdminMessageDAO;
import com.nowcoder.model.Comment;
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
 * @Time 23:11
 */
@Service
public class AdminCommentService {
    private static final Logger logger = LoggerFactory.getLogger(AdminCommentService.class);

    @Autowired
    private AdminCommentDAO adminCommentDAO;

    public void closeComment(int id) {
        adminCommentDAO.updateCommentState(id);
    }

    public void openComment(int id) {
        adminCommentDAO.updateCommentState0(id);
    }

    public int countComment() {
        return adminCommentDAO.selectCountComment();
    }

    public void delComment(int id) {
        adminCommentDAO.deleteComment(id);
    }

    public List<Comment> listComment() {
        return adminCommentDAO.selectComments();
    }
}
