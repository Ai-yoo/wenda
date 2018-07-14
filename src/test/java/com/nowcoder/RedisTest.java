package com.nowcoder;

import com.alibaba.fastjson.JSONObject;
import com.nowcoder.model.User;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/11
 * @Time 17:21
 */
public class RedisTest {

    @Test
    public void jedisConnection() {
        Jedis jedis=new Jedis("redis://localhost:6379");
        jedis.set("k", "v");
        System.out.println(jedis.keys("*"));
        System.out.println("----");
        System.out.println(jedis.get("k"));

        /**
         * 使用redis实现缓存，把对象序列化存到redis中
         * 之后通过键值对取出来，并通过反序列化得出值
         */
        User user = new User();
        user.setId(1);
        user.setName("name");
        user.setPassword("ppp");
        user.setSalt("salt");
        user.setHeadUrl("***");
        jedis.set("user1", JSONObject.toJSONString(user));

        String value = jedis.get("user1");
        User user1 = JSONObject.parseObject(value, User.class);
        System.out.println(user1.toString());

    }
}
