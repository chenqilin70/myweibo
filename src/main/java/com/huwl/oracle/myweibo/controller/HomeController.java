package com.huwl.oracle.myweibo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inner")
public class HomeController {
    @RequestMapping("/home")
    public String home(){return "home";}
}
