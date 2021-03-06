package com.huwl.oracle.myweibo.pojo;

import java.io.Serializable;
import java.util.Date;

public class Replay  implements Serializable {
    private static final long serialVersionUID = -7898194272883238670L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REPLAY.REPLAY_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private Integer replayId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REPLAY.REPLAY_CONTENT
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private String replayContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REPLAY.REPLAY_TIMIE
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private Date replayTimie;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REPLAY.TO_USER
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private User toUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column REPLAY.USER_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private User user;

    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REPLAY.REPLAY_ID
     *
     * @return the value of REPLAY.REPLAY_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public Integer getReplayId() {
        return replayId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REPLAY.REPLAY_ID
     *
     * @param replayId the value for REPLAY.REPLAY_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setReplayId(Integer replayId) {
        this.replayId = replayId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REPLAY.REPLAY_CONTENT
     *
     * @return the value of REPLAY.REPLAY_CONTENT
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public String getReplayContent() {
        return replayContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REPLAY.REPLAY_CONTENT
     *
     * @param replayContent the value for REPLAY.REPLAY_CONTENT
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setReplayContent(String replayContent) {
        this.replayContent = replayContent == null ? null : replayContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column REPLAY.REPLAY_TIMIE
     *
     * @return the value of REPLAY.REPLAY_TIMIE
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public Date getReplayTimie() {
        return replayTimie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column REPLAY.REPLAY_TIMIE
     *
     * @param replayTimie the value for REPLAY.REPLAY_TIMIE
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setReplayTimie(Date replayTimie) {
        this.replayTimie = replayTimie;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}