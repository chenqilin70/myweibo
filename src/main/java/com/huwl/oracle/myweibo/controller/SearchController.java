package com.huwl.oracle.myweibo.controller;

import com.huwl.oracle.myweibo.biz.SearchBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RequestMapping("/inner")
@Controller("searchController")
public class SearchController {
    @Autowired
    private SearchBiz searchBiz;
    @RequestMapping("/search/{searchStr}/{pageNo}")
    public ModelAndView search(@PathVariable("searchStr") String searchStr
                ,@PathVariable("pageNo") Integer pageNo){
        try {
           searchStr=new String(searchStr.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ModelAndView mv=new ModelAndView("search");
        mv.addObject("weibo_search_result"
                ,searchBiz.searchWeiboByStr(pageNo,searchStr));
        mv.addObject("user_search_result"
                ,searchBiz.searchIncidentalUserByStr(searchStr));
        mv.addObject("action","weibo");
        return mv;
    }
    @RequestMapping("/search_user/{searchStr}/{pageNo}")
    public ModelAndView search_user(@PathVariable("searchStr") String searchStr
            ,@PathVariable("pageNo") Integer pageNo){
        ModelAndView mv=new ModelAndView("search");
        try {
            searchStr=new String(searchStr.getBytes("ISO-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        mv.addObject("user_search_result"
                ,searchBiz.searchUserByStr(pageNo,searchStr));
        mv.addObject("action","user");
        return mv;
    }
}
