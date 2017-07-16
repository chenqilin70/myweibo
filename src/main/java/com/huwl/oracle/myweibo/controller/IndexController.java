package com.huwl.oracle.myweibo.controller;

import com.huwl.oracle.myweibo.biz.IndexBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

@Controller
public class IndexController {
    @Autowired
    private IndexBiz indexBiz;
    @RequestMapping(value="index")
    public String index(){
        return "index";
    }
    @RequestMapping(value="validateImg")
    public void validateImg(HttpServletResponse response){
        OutputStream out=null;
        try {
            out=response.getOutputStream();
            String code=indexBiz.getRandomValidateCode();
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

}

















