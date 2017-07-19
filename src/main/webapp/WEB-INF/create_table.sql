CREATE TABLE USERS(
USER_ID INT auto_increment primary key,
NICK_NAME VARCHAR(255),
PASSWORD VARCHAR(255),
BIRTHDAY DATETIME,
INTRO VARCHAR(255),
SEX BOOLEAN,
ADDRESS VARCHAR(255)
);
CREATE TABLE WEI_BO (
WEIBO_ID INT auto_increment primary key,
USER_ID INT ,
WEIBO_CONTENT VARCHAR(255),
PUBLISH_TIME DATETIME,
READ_TIMES INT,
IS_REPOST BOOLEAN,
REPOST_ID INT,
foreign key(REPOST_ID) references WEI_BO(WEIBO_ID),
foreign key(USER_ID) references USERS(USER_ID)
);

CREATE TABLE LIKES(
LIKE_ID INT auto_increment primary key,
USER_ID INT,
LIKE_TIME DATETIME,
WEIBO_ID INT,
foreign key(WEIBO_ID) references WEI_BO(WEIBO_ID),
foreign key(USER_ID) references USERS(USER_ID)
);
CREATE TABLE COMMENTS(
COMMENT_ID INT auto_increment primary key,
COMMENT_CONTENT VARCHAR(255),
COMMENT_TIME DATETIME,
USER_ID INT,
foreign key(USER_ID) references USERS(USER_ID)
);
CREATE TABLE REPLAY(
REPLAY_ID INT  auto_increment primary key,
REPLAY_CONTENT VARCHAR(255),
REPLAY_TIMIE DATETIME,
TO_USER INT,
USER_ID INT,
foreign key(USER_ID) references USERS(USER_ID),
foreign key(TO_USER) references USERS(USER_ID)
);
CREATE TABLE USER_GROUP(
GROUP_ID INT  auto_increment primary key,
GROUP_NAME VARCHAR(255),
USER_ID INT,
SET_UP_TIME DATETIME,
foreign key(USER_ID) references USERS(USER_ID)
);
CREATE TABLE RELATIONSHIP(
RELAT_ID INT auto_increment primary key,
STAR_ID INT,
CARE_TIME DATETIME,
GROUP_ID INT,
foreign key(STAR_ID) references USERS(USER_ID)
);
