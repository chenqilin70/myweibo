package com.huwl.oracle.myweibo.controller;

import com.huwl.oracle.myweibo.biz.UserCenterBiz;
import com.huwl.oracle.myweibo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("/inner")
@Controller
public class UserCenterController {
    @Autowired
    private UserCenterBiz userCenterBiz;
    @RequestMapping("/user_center")
    public ModelAndView userCenter(HttpSession session){
        ModelAndView mav=new ModelAndView("user_center");
        Integer userid=((User)session.getAttribute("user")).getUserId();
        mav.addObject("myWeiboList"
                , userCenterBiz.getUserWeiboList(1,15,userid));
        return mav;
    }
}
