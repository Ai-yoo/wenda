package com.nowcoder.admin.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created with IDEA
 *
 * @author duzhentong
 * @Date 2019/5/6
 * @Time 23:19
 */
@Mapper
public interface AdminQuestionDAO {
    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title,content,created_date,user_id,comment_count,state ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Update("update " + TABLE_NAME + " set state=1 where id=#{id}")
    void updateQuestionState(int id);

    @Delete("delete from " + TABLE_NAME + "where id =#{id}")
    void deleteQuestion(int id);

    @Select("select count(*) from question")
    int selectCountQuestion();

}
