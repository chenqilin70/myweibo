package com.huwl.oracle.myweibo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huwl.oracle.myweibo.biz.SearchBiz;
import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.User;
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
public class SearchController {
    @Autowired
    private SearchBiz searchBiz;

    @RequestMapping("/search/{searchStr}")
    public ModelAndView search_weibo(@PathVariable(value = "searchStr") String searchStr){
        System.out.println("search_weibo"+searchStr);
        try {
           searchStr=new String(searchStr.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
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
        System.out.println("search_weibo_ajax"+searchStr+pageNo);
        ModelAndView mv=new ModelAndView("weibo");
        try {
            searchStr=new String(searchStr.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mv.addObject("pageBean",searchBiz.getSearchWeiboPageBean(searchStr,pageNo));
        mv.addObject("weibo_search_result"
                ,searchBiz.searchWeiboByStr(pageNo,searchStr));
        return mv;
    }
    @RequestMapping("/search_user/{searchStr}")
    public ModelAndView search_user(@PathVariable("searchStr") String searchStr){
        ModelAndView mv=new ModelAndView("search");
        try {
            searchStr=new String(searchStr.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mv.addObject("action","user");
        mv.addObject("searchStr",searchStr);
        return mv;
    }
    @RequestMapping("/search_user")
    public ModelAndView search_user_ajax(@RequestParam("searchStr") String searchStr
            , @RequestParam("page") Integer pageNo, HttpSession session){
        System.out.println("search_user_ajax");
        ModelAndView mv=new ModelAndView("user_search_result");
        try {
            searchStr=new String(searchStr.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mv.addObject("pageBean",searchBiz.getSearchUserPageBean(searchStr,pageNo));
        mv.addObject("user_search_result"
                ,searchBiz.searchUserByStr(pageNo,searchStr,(User) session.getAttribute("user")));
        return mv;
    }
    @ResponseBody
    @RequestMapping("/inner/{userid}")
    public boolean addCared(@PathVariable Integer userid,HttpSession session){
        User loginedUser= (User) session.getAttribute("user");
        return searchBiz.addCared(userid,loginedUser);
    }
}
