package com.nowcoder.async;

import java.util.List;


public interface EventHandler {

    void doHandle(EventModel model);

    /**
     * 不同的handler关注的自己能够处理的消息
     * @return
     */
    List<EventType> getSupportEventTypes();
}
