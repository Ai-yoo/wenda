package com.admin.dao;

import com.admin.model.Root;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/5/5
 * @Time 23:25
 */
@Mapper
public interface AdminLoginDAO {
    String TABLE_NAME = " root ";
    String INSERT_FIELDS = " name,password ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Select("select " + SELECT_FIELDS + "from" + TABLE_NAME + "where name=#{name}")
    Root selectByName(String name);
}
