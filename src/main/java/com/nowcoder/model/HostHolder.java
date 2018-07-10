package com.nowcoder.model;

import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * 定义一个拦截器，
 *
 * @author duzhentong
 * @Date 2018/7/9
 * @Time 9:51
 */
@Component
public class HostHolder {
    /**
     * 因为每个用户都有自己的信息，，如果定义一个静态属性，那么所有的用户都是一个信息，
     * 这里使用一个ThreadLocal，对于每个线程都有一个变量
     */
    private static ThreadLocal<User> users = new ThreadLocal<>();

    

    public User getUser() {
        return users.get();
    }

    public void setUsesr(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
