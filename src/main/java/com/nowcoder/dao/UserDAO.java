package com.nowcoder.dao;

import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/8
 * @Time 9:49
 */
@Mapper
public interface UserDAO {

    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " name,password,salt,head_url,email,state ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values(#{name},#{password},#{salt},#{headUrl},#{email},#{state})"})
    int addUser(User user);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, "where id=#{id}"})
    User selectById(int id);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, "where name=#{name}"})
    User selectByName(String name);

    @Update({"update", TABLE_NAME, "set password=#{password},salt=#{salt} where id=#{id}"})
    void updatePassword(User user);

    @Delete({"delete from ", TABLE_NAME, "where id=#{id}"})
    void deleteById(int id);

}
