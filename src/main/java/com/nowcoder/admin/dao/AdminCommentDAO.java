package com.nowcoder.admin.dao;

import com.nowcoder.model.Comment;
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
 * @Time 23:45
 */
@Mapper
public interface AdminCommentDAO {
    String TABLE_NAME = " comment ";
    String INSERT_FIELDS = " user_id,content,created_date,entity_id,entity_type,state ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Update("update " + TABLE_NAME + " set state=1 where id=#{id}")
    void updateCommentState(int id);

    @Update("update " + TABLE_NAME + " set state=0 where id=#{id}")
    void updateCommentState0(int id);

    @Delete("delete from "+TABLE_NAME+"where id=#{id}")
    void deleteComment(int id);

    @Select("select count(*) from comment")
    int selectCountComment();

    @Select({"select", SELECT_FIELDS, "from ", TABLE_NAME })
    List<Comment> selectComments();

}
