package com.huwl.oracle.myweibo.controller;

import com.huwl.oracle.myweibo.biz.HomeBiz;
import com.huwl.oracle.myweibo.pojo.User;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/inner")
public class HomeController {
    @Autowired
    private HomeBiz homeBiz;
    @RequestMapping("/home")
    public String home(HttpServletRequest request,HttpSession session){
        Integer userid=((User)session.getAttribute("user")).getUserId();
        request.setAttribute("weiboCount"
                ,homeBiz.getWeiboCount(userid));
        return "home";
    }
    @RequestMapping("/publishWeibo")
    public void publishWeibo(@RequestParam(value="pics",required = false) CommonsMultipartFile[] pics
            ,@RequestParam("weiboContent")String weiboContent
            ,HttpServletResponse response,HttpServletRequest request){
        Integer userid=((User)request.getSession().getAttribute("user")).getUserId();
        homeBiz.publishWeibo(weiboContent,pics,userid);

        try {
            response.getWriter().write("sdfsdfdsfdsf");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
