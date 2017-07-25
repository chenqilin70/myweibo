package com.huwl.oracle.myweibo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User  implements Serializable {
    private static final long serialVersionUID = -7898194272883238670L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.USER_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.NICK_NAME
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.BIRTHDAY
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.INTRO
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private String intro;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.SEX
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private Boolean sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.ADDRESS
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.PASSWORD
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.USER_ID
     *
     * @return the value of USERS.USER_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    private String headImg;

    private List<UserGroup> groups;

    public List<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroup> groups) {
        this.groups = groups;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.USER_ID
     *
     * @param userId the value for USERS.USER_ID
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.NICK_NAME
     *
     * @return the value of USERS.NICK_NAME
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.NICK_NAME
     *
     * @param nickName the value for USERS.NICK_NAME
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.BIRTHDAY
     *
     * @return the value of USERS.BIRTHDAY
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.BIRTHDAY
     *
     * @param birthday the value for USERS.BIRTHDAY
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.INTRO
     *
     * @return the value of USERS.INTRO
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public String getIntro() {
        return intro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.INTRO
     *
     * @param intro the value for USERS.INTRO
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.SEX
     *
     * @return the value of USERS.SEX
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.SEX
     *
     * @param sex the value for USERS.SEX
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.ADDRESS
     *
     * @return the value of USERS.ADDRESS
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.ADDRESS
     *
     * @param address the value for USERS.ADDRESS
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.PASSWORD
     *
     * @return the value of USERS.PASSWORD
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.PASSWORD
     *
     * @param password the value for USERS.PASSWORD
     *
     * @mbggenerated Tue Jul 18 08:02:56 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public User(Integer userId, String nickName, Date birthday, String intro, Boolean sex, String address, String password, String headImg) {
        this.userId = userId;
        this.nickName = nickName;
        this.birthday = birthday;
        this.intro = intro;
        this.sex = sex;
        this.address = address;
        this.password = password;
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", birthday=" + birthday +
                ", intro='" + intro + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {}
}