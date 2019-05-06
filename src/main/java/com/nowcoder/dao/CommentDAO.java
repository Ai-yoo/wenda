package com.nowcoder.dao;

import com.nowcoder.model.Comment;
import com.nowcoder.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/10
 * @Time 11:07
 */
@Mapper
public interface CommentDAO {
    String TABLE_NAME = " comment ";
    String INSERT_FIELDS = " user_id,content,created_date,entity_id,entity_type,state ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") " +
            "values(#{userId},#{content},#{createdDate},#{entityId},#{entityType},#{state})"})
    int addComment(Comment comment);


    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME,
            "where entity_id=#{entityId} and entity_type=#{entityType} order by created_date desc"})
    List<Comment> selectCommentByEntityId(@Param("entityId") int entityId,
                                         @Param("entityType") int entityType);


    @Select({"select count(id) from", TABLE_NAME,
            "where entity_id=#{entityId} and entity_type=#{entityType}"})
    int getCommentCount(@Param("entityId") int entityId,
                        @Param("entityType") int entityType);

    @Update({"update", TABLE_NAME, "set status=#{status} where id=#{id}"})
    int updateState(@Param("status") int state, @Param("id") int id);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Comment getCommentById(int id);
}

