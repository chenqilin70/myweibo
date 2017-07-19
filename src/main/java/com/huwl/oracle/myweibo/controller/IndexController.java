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
    public String register(@Param("username") String username
            , @Param("username") String password, @Param("validateCode") String validateCode
            , HttpSession session, HttpServletRequest request){
        String code= (String) session.getAttribute("validateCode");
        session.removeAttribute("validateCode");
        if(validateCode.equalsIgnoreCase(code)){
            User user=indexBiz.register(username,password);
            if(user==null){
                request.setAttribute("registerError_nickname","用户名已存在！");
                return "index";
            }else{
                session.setAttribute("user",user);
                return "test";
            }

        }else{
            request.setAttribute("registerError_validate","验证码输入错误！");
            return "index";
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
    public String login(@Param("nickname") String nickname,String password
            ,HttpSession session,HttpServletRequest request){
        User user=indexBiz.login(nickname,password);
        if(user==null){
            request.setAttribute("loginError","用户名或密码错误！");
            return "index";
        }else{
            session.setAttribute("user",user);
            return "test";
        }
    }




}

















