package com.huwl.oracle.myweibo.controller;

import com.huwl.oracle.myweibo.biz.HomeBiz;
import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
}
