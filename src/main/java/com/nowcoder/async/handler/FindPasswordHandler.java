package com.nowcoder.async.handler;

import com.nowcoder.async.EventHandler;
import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventType;
import com.nowcoder.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/2/9
 * @Time 18:34
 */

@Component
public class FindPasswordHandler implements EventHandler {

    @Autowired
    MailSender mailSender;

    @Override
    public void doHandle(EventModel model) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", model.getExt("username"));
        map.put("msg", model.getExt("msg"));
        mailSender.sendWithHTMLTemplate(model.getExt("email"), "找回密码", "mails/send_msg.html", map);
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.FIND_PASSWORD);
    }

}
