package com.huwl.oracle.myweibo.daoimpl;

import com.huwl.oracle.myweibo.dao.BaseDao;
import com.huwl.oracle.myweibo.wrapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by aierxuan on 2017/7/17.
 */
@Repository
public abstract class BaseDaoImpl implements BaseDao {
    private Class TYPE;
    public BaseDaoImpl(Class TYPE) {
        this.TYPE = TYPE;
    }
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SqlSessionFactory factory;

    public SqlSession getSession(){
        return factory.openSession();
    }



}
