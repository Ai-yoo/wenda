package com.nowcoder.dao;

import com.nowcoder.model.Question;
import com.nowcoder.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2018/7/8
 * @Time 9:49
 */
@Mapper
public interface QuestionDAO {

    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title,content,created_date,user_id,comment_count ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values(#{title},#{content},#{createdDate},#{userId},#{commentCount})"})
    int addQuestion(Question question);


//    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, "where id=#{id}"})
    List<Question> selectLatestQuestions(@Param("userId") int userId,
                                         @Param("offset") int offset,
                                         @Param("limit") int limit);


    @Select({"select", SELECT_FIELDS, "from ", TABLE_NAME ,"order by created_date"})
    List<Question> selectQuestions();

    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where id=#{id}"})
    Question selectById(int id);

    @Update({"update", TABLE_NAME, "set comment_count=#{commentCount} where id=#{id}"})
    void updateCommentCount(@Param("commentCount") int commentCount, @Param("id") int id);

    @Select({"select count(*) from", TABLE_NAME})
    int getQuestionNum();

}
