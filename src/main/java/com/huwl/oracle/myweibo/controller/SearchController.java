package com.huwl.oracle.myweibo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwl.oracle.myweibo.biz.SearchBiz;
import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.pojo.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RequestMapping("/inner")
@Controller("searchController")
public class SearchController extends BaseController{
    @Autowired
    private SearchBiz searchBiz;

    @RequestMapping("/search/{searchStr}")
    public ModelAndView search_weibo(@PathVariable(value = "searchStr") String searchStr){
        searchStr=correctEncoding(searchStr);
        ModelAndView mv=new ModelAndView("search");

        mv.addObject("user_search_result"
                ,searchBiz.searchIncidentalUserByStr(searchStr));
        mv.addObject("action","weibo");
        mv.addObject("searchStr",searchStr);
        return mv;
    }
    @RequestMapping("/search")
    public ModelAndView search_weibo_ajax(@RequestParam("searchStr") String searchStr
            ,@RequestParam("page") Integer pageNo){
        ModelAndView mv=new ModelAndView("weibo");
        searchStr=correctEncoding(searchStr);
        mv.addObject("pageBean",searchBiz.getSearchWeiboPageBean(searchStr,pageNo));
        mv.addObject("weibo_search_result"
                ,searchBiz.searchWeiboByStr(pageNo,searchStr));
        return mv;
    }
    @RequestMapping("/search_user/{searchStr}")
    public ModelAndView search_user(@PathVariable("searchStr") String searchStr){
        ModelAndView mv=new ModelAndView("search");
        searchStr=correctEncoding(searchStr);
        mv.addObject("action","user");
        mv.addObject("searchStr",searchStr);
        return mv;
    }
    @RequestMapping("/search_user")
    public ModelAndView search_user_ajax(@RequestParam("searchStr") String searchStr
            , @RequestParam("page") Integer pageNo, HttpSession session){
        System.out.println("search_user_ajax");
        ModelAndView mv=new ModelAndView("user_search_result");
        searchStr=correctEncoding(searchStr);
        User loginUser=getLoginedUser(session);
        mv.addObject("groups",searchBiz.getGroupsByUser(loginUser));
        mv.addObject("pageBean",searchBiz.getSearchUserPageBean(searchStr,pageNo,loginUser));
        mv.addObject("user_search_result"
                ,searchBiz.searchUserByStr(pageNo,searchStr,loginUser));
        return mv;
    }
    @ResponseBody
    @RequestMapping("/addCare/{userid}")
    public boolean addCare(@PathVariable Integer userid,HttpSession session){
        User loginedUser= getLoginedUser(session);
        return searchBiz.addCare(userid,loginedUser);
    }
    @ResponseBody
    @RequestMapping("/grouping")
    public boolean grouping(@RequestParam("groupid") Integer groupid
            ,@RequestParam("userid") Integer userid,HttpSession session){
        User loginedUser= getLoginedUser(session);
        return searchBiz.grouping(groupid,userid,loginedUser);
    }
    @ResponseBody
    @RequestMapping("/addGroup")
    public String addGroup(UserGroup userGroup,HttpSession session){
        User loginedUser= getLoginedUser(session);
        UserGroup group=searchBiz.addGroup(userGroup,loginedUser);
        return group.getGroupId()+"";
    }
    @ResponseBody
    @RequestMapping("/cancelCare")
    public String cancelCare(User targetUser,HttpSession session){
        User loginedUser= getLoginedUser(session);
        return searchBiz.cancelCare(loginedUser,targetUser)+"";
    }
    @ResponseBody
    @RequestMapping("/getGroupIdByFans")
    public String getGroupIdByFans(HttpSession session,User targetUser){
        User loginedUser= getLoginedUser(session);
        return searchBiz.getGroupIdByFans(loginedUser,targetUser);
    }


}
