package com.nowcoder.admin.dao;

import com.nowcoder.model.Message;
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
 * @Time 23:47
 */
@Mapper
public interface AdminMessageDAO {
    String TABLE_NAME = "message";
    String INSERT_FIELDS = " from_Id,to_Id,content,created_date,has_read,conversation_id,state";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Update("update " + TABLE_NAME + " set state=1 where id=#{id}")
    void updateMessageState(int id);

    @Update("update " + TABLE_NAME + " set state=0 where id=#{id}")
    void updateMessageState0(int id);

    @Delete("delete from " + TABLE_NAME + "where id=#{id}")
    void deleteMessage(int id);

    @Select("select count(*) from message")
    int selectCountMessage();

    @Select({"select", SELECT_FIELDS, "from ", TABLE_NAME })
    List<Message> selectMessages();
}
