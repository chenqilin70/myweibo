package com.huwl.oracle.myweibo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Comment implements Serializable{
    private static final long serialVersionUID = -7898194272883238670L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENTS.COMMENT_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private Integer commentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENTS.COMMENT_CONTENT
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private String commentContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENTS.COMMENT_TIME
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private Date commentTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column COMMENTS.USER_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private User user;
    private Weibo weibo;
    private List<Replay> replays;

    public List<Replay> getReplays() {
        return replays;
    }

    public void setReplays(List<Replay> replays) {
        this.replays = replays;
    }

    public Weibo getWeibo() {
        return weibo;
    }

    public void setWeibo(Weibo weibo) {
        this.weibo = weibo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENTS.COMMENT_ID
     *
     * @return the value of COMMENTS.COMMENT_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENTS.COMMENT_ID
     *
     * @param commentId the value for COMMENTS.COMMENT_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENTS.COMMENT_CONTENT
     *
     * @return the value of COMMENTS.COMMENT_CONTENT
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENTS.COMMENT_CONTENT
     *
     * @param commentContent the value for COMMENTS.COMMENT_CONTENT
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column COMMENTS.COMMENT_TIME
     *
     * @return the value of COMMENTS.COMMENT_TIME
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column COMMENTS.COMMENT_TIME
     *
     * @param commentTime the value for COMMENTS.COMMENT_TIME
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}