package com.admin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

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
}
