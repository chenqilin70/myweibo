package com.huwl.oracle.myweibo.dao;

import org.apache.ibatis.session.SqlSession;

/**
 * Created by aierxuan on 2017/7/17.
 */
public interface BaseDao {
    SqlSession getSession();
}
