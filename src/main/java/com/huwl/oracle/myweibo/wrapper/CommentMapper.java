package com.huwl.oracle.myweibo.wrapper;

import com.huwl.oracle.myweibo.pojo.Comment;
import java.util.List;

public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbggenerated Mon Jul 17 19:04:18 CST 2017
     */
    int deleteByPrimaryKey(Integer commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbggenerated Mon Jul 17 19:04:18 CST 2017
     */
    int insert(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbggenerated Mon Jul 17 19:04:18 CST 2017
     */
    Comment selectByPrimaryKey(Integer commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbggenerated Mon Jul 17 19:04:18 CST 2017
     */
    List<Comment> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table COMMENTS
     *
     * @mbggenerated Mon Jul 17 19:04:18 CST 2017
     */
    int updateByPrimaryKey(Comment record);
}