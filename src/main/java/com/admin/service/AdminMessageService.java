package com.admin.service;

import com.admin.dao.AdminMessageDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

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
}
