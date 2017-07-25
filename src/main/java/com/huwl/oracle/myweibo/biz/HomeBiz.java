package com.huwl.oracle.myweibo.biz;

import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.pojo.Weibo;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller("homeBiz")
public class HomeBiz extends BaseBiz{

    public Integer getWeiboCount(Integer userid) {

        return null;
    }

    public void publishWeibo(String weiboContent, CommonsMultipartFile[] pics
            , User user, String imgPath) {
        File root=new File(imgPath);
        if(!root.exists())root.mkdirs();
        StringBuffer uuids=null;
        if(pics!=null && pics.length>0){
            uuids=new StringBuffer("");
            try {
                for(CommonsMultipartFile p:pics){
                    String filename=UUID.randomUUID().toString();
                    uuids.append(filename+",");
                    File file=new File(root.getAbsolutePath(), ""+filename);
                    FileUtils.copyInputStreamToFile(p.getInputStream(),file);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            uuids=new StringBuffer(uuids.substring(0,uuids.lastIndexOf(",")));
        }
        Weibo weibo=new Weibo();
        weibo.setIsRepost(false)
                .setPublishTime(new Date())
                .setReadTimes(0)
                .setUser(user)
                .setWeiboContent(weiboContent)
                .setPics(uuids==null?null:uuids.toString());
       weiboMapper.insert(weibo);
    }
}
