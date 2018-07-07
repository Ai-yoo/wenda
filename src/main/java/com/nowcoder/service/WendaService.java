package com.nowcoder.service;

import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/7
 * @Time 17:01
 */

@Service
public class WendaService {
    public String getMessage(int userId) {
        return "Hello Message" + String.valueOf(userId);
    }
}
