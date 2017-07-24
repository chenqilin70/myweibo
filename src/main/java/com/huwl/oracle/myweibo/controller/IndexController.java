package com.huwl.oracle.myweibo.controller;

import com.huwl.oracle.myweibo.biz.IndexBiz;
import com.huwl.oracle.myweibo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
@RequestMapping
@Controller
public class IndexController {
    @Autowired
    private IndexBiz indexBiz;
    @RequestMapping(value="index")
    public String index(){return "index";}
    @RequestMapping(value="validateImg")
    public void validateImg(HttpServletResponse response,HttpSession session){
        OutputStream out=null;
        try {
            out=response.getOutputStream();
            String code=indexBiz.getRandomValidateCode();
            System.out.println(code+"<--验证码");
            session.setAttribute("validateCode",code);
            byte[] img=indexBiz.getValidateImg(code);
            out.write(img);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
    @RequestMapping(value="register")
    public void register(@Param("username") String username
            , @Param("username") String password, @Param("validateCode") String validateCode
            , HttpSession session, HttpServletRequest request,HttpServletResponse response) {
        String code = (String) session.getAttribute("validateCode");
        session.removeAttribute("validateCode");
        session.removeAttribute("registerError_nickname");
        session.removeAttribute("registerError_validate");
        String contextPath=request.getContextPath();
        if (validateCode.equalsIgnoreCase(code)) {
            User user = indexBiz.register(username, password);
            if (user == null) {
                session.setAttribute("registerError_nickname", "用户名已存在！");
                try {
                    response.sendRedirect(contextPath+"/index");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                session.setAttribute("user", user);
                try {
                    response.sendRedirect(contextPath+"/inner/home");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            session.setAttribute("registerError_validate", "验证码输入错误！");
            try {
                response.sendRedirect(contextPath+"/index");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping(value="existNickname")
    public void existNickname(@Param("nickname") String nickname,HttpServletResponse response){
        boolean flag=indexBiz.existNickname(nickname);
        try {
            response.getWriter().write(""+flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("isValidateCodeRight")
    public void isValidateCodeRight(@Param("validateCode") String validateCode,HttpSession session,HttpServletResponse response) {
        String codeInSession= (String) session.getAttribute("validateCode");
        Writer writer=null;
        try {
            writer=response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(codeInSession.equalsIgnoreCase(validateCode)){
            try {
                writer.write("true");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                writer.write("false");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("login")
    public void login(@Param("nickname") String nickname,String password
            ,HttpSession session,HttpServletRequest request,HttpServletResponse response){
        User user=indexBiz.login(nickname,password);
        String contextPath=request.getContextPath();
        String path="";
        session.removeAttribute("loginError");
        if(user==null){
            session.setAttribute("loginError","用户名或密码错误！");
            path=contextPath+"/index";
        }else{
            session.setAttribute("user",user);
            path=contextPath+"/inner/home";
        }
        try {
            response.sendRedirect(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}

















