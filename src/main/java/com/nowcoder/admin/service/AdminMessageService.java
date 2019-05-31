package com.nowcoder.admin.service;

import com.nowcoder.admin.dao.AdminMessageDAO;
import com.nowcoder.model.Message;
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
 * @Time 23:09
 */
@Service
public class AdminMessageService {
    private static final Logger logger = LoggerFactory.getLogger(AdminMessageService.class);

    @Autowired
    private AdminMessageDAO adminMessageDAO;

    public void closeMessage(int id) {
        adminMessageDAO.updateMessageState(id);
    }

    public void openMessage(int id) {
        adminMessageDAO.updateMessageState0(id);
    }

    public int countMessage() {
        return adminMessageDAO.selectCountMessage();
    }

    public void delMessage(int id) {
        adminMessageDAO.deleteMessage(id);
    }

    public List<Message> listMessage() {
        return adminMessageDAO.selectMessages();
    }
}
