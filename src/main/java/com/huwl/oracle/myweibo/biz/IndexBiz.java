package com.huwl.oracle.myweibo.biz;

import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.pojo.UserGroup;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;

@Service
public class IndexBiz extends BaseBiz{
    private Random random=new Random();
    private static List<Integer> options=new ArrayList<Integer>();
    {
        for(int i=65;i<=90;i++){
            options.add(i);
        }
        for(int i=97;i<=122;i++){
            options.add(i);
        }
        for(int i=48;i<=57;i++){
            options.add(i);
        }
    }
    public String  getRandomValidateCode() {
        List<Integer> indexs=new ArrayList<Integer>();
        for(int i=0;i<=3;i++){
            indexs.add(random.nextInt(options.size()-1));
        }
        StringBuffer sb=new StringBuffer();
        for(Integer index:indexs){
            sb.append(((char)(options.get(index).intValue())));
        }
        return sb.toString();
    }

    public byte[] getValidateImg(String code) {
        BufferedImage codeImg=new  BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g=codeImg.getGraphics();
        g.setFont(new Font("微软雅黑", Font.ITALIC, 25));
        g.setColor(new Color(238,238,238));
        g.fillRect(0, 0, 105, 40);
        for(int i=0;i<=3;i++){
            g.setColor(getRandomColor());
            g.drawString(code.substring(i,i+1), i*25, 30);
        }
        for(int i=0;i<=10;i++){
            g.setColor(getRandomColor());
            int roundRectWidth=random.nextInt(8);
            int roundRectHight=random.nextInt(8);
            g.fillRoundRect(random.nextInt(105), random.nextInt(40)
                    , roundRectWidth, roundRectHight
                    , roundRectWidth/2, roundRectHight/2);
            g.drawLine(random.nextInt(105), random.nextInt(40), random.nextInt(105), random.nextInt(40));
        }

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        try {
            ImageIO.write(codeImg, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
    private  Color getRandomColor(){
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    public User register(String nickname, String password) {
        boolean flag=userMapper.existNickname(nickname)>0?true:false;
        if(!flag){
            User user=new User(null,nickname,null,null,null,null,password,"default.jpg");
            userMapper.insert(user);
            UserGroup userGroup=new UserGroup();
            userGroup.setGroupName("未分组");
            userGroup.setSetUpTime(new Date());
            userGroup.setUser(user);
            userGroupMapper.insert(userGroup);
            return user;
        }
        return null;
    }

    public User login(String nickname, String password) {
        User user=new User();
        user.setNickName(nickname);
        user.setPassword(password);
        user=userMapper.getUserByCondition(user);
        if(user!=null){
            user.setPassword("******");
        }
        return user;
    }

    public boolean existNickname(String nickname) {
        nickname=correctEncoding(nickname);
        return userMapper.existNickname(nickname)>0?true:false;
    }
}
