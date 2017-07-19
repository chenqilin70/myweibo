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
        session.invalidate();
        if(validateCode.equalsIgnoreCase(code)){
            User user=indexBiz.register(username,password);
            if(user==null){
                request.setAttribute("registerError_nickname","用户名已存在！");
                return "index";
            }else{
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
        response.getWriter().write(""+flag);
    }




}

















