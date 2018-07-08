package com.nowcoder.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/8
 * @Time 18:23
 */
public class ViewObject {
    private Map<String, Object> objs = new HashMap<>();

    public void set(String key, Object value) {
        objs.put(key, value);
    }

    public Object get(String key) {
        return objs.get(key);
    }
}
