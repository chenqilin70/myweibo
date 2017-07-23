package com.huwl.oracle.myweibo.biz;

import com.huwl.oracle.myweibo.pojo.Weibo;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

@Controller("homeBiz")
public class HomeBiz extends BaseBiz{

    public Integer getWeiboCount(Integer userid) {

        return null;
    }

    public void publishWeibo(String weiboContent, CommonsMultipartFile[] pics,Integer userid) {
        Weibo weibo=new Weibo();
        weibo.setIsRepost(false)
             .setPublishTime(new Date())
             .setReadTimes(0)
             .setUserId(userid)
             .setWeiboContent(weiboContent);
        for(CommonsMultipartFile file:pics){
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream()
                        ,new File("D:/tempFile/"+new Date().getTime()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
