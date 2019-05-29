package com.nowcoder.admin.dao;

import com.nowcoder.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/5/6
 * @Time 23:59
 */
@Mapper
public interface AdminUserDAO {
    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " name,password,salt,head_url,email,state ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Update("update " + TABLE_NAME + " set state =1 where id=#{id}")
    void updateUserState(int id);

    @Update("update " + TABLE_NAME + " set state =0 where id=#{id}")
    void updateUserState0(int id);

    @Delete("delete from " + TABLE_NAME + "where id=#{id}")
    void deleteUser(int id);

    @Select("select count(*) from user")
    int selectCountUser();

    @Select({"select", SELECT_FIELDS, "from ", TABLE_NAME })
    List<User> selectUsers();

}
