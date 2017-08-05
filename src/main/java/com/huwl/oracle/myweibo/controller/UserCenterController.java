package com.huwl.oracle.myweibo.controller;

import com.huwl.oracle.myweibo.biz.UserCenterBiz;
import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping("/inner")
@Controller
public class UserCenterController extends BaseController{
    @Autowired
    private UserCenterBiz userCenterBiz;
    @RequestMapping("/user_center")
    public ModelAndView userCenter(HttpSession session){
        ModelAndView mav=new ModelAndView("user_center");
        return mav;
    }
    @RequestMapping("/user_center_weibo")
    public ModelAndView userCenterWeibo(HttpSession session,@RequestParam("page") Integer pageNo){
        ModelAndView mav=new ModelAndView("weibo");
        User user= (User) session.getAttribute("user");
        mav.addObject("weibo_search_result"
                , userCenterBiz.getUserWeiboList(pageNo,15,user));
        mav.addObject("pageBean",userCenterBiz.getUserWeiboPageBean(pageNo,user));
        return mav;
    }
    @RequestMapping("/like")
    public void like(@RequestParam("weiboid")Integer weiboid
            ,HttpSession session,HttpServletResponse response) {
        String flag=userCenterBiz.like(getLoginedUser(session),weiboid);
        try {
            response.getWriter().write(flag+"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
