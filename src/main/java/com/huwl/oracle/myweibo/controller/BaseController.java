package com.huwl.oracle.myweibo.controller;

import com.huwl.oracle.myweibo.pojo.User;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by aierxuan on 2017/7/28.
 */
public class BaseController {
    protected String correctEncoding(String s){
        try {
            return new String(s.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return s;
        }
    }
    protected User getLoginedUser(HttpSession session){
        return (User) session.getAttribute("user");
    }
}
