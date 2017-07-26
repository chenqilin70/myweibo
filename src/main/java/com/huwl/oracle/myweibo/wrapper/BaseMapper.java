package com.huwl.oracle.myweibo.wrapper;

import java.util.List;

/**
 * Created by aierxuan on 2017/7/18.
 */
public interface BaseMapper<T> {
    int insert(T o);
    List<T> select(T t);
}
