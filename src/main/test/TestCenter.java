
import com.huwl.oracle.myweibo.pojo.Like;
import com.huwl.oracle.myweibo.pojo.PageBean;
import com.huwl.oracle.myweibo.pojo.User;
import com.huwl.oracle.myweibo.pojo.Weibo;
import com.huwl.oracle.myweibo.wrapper.LikeMapper;
import com.huwl.oracle.myweibo.wrapper.UserMapper;
import com.huwl.oracle.myweibo.wrapper.WeiboMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.*;

/**
 * Created by aierxuan on 2017/7/18.
 */
public class TestCenter {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-*.xml");
        /*LikeMapper mapper= (LikeMapper) ctx.getBean("likeMapper");
        Like like=new Like();
        like.setLikeTime(new Date());
        User user=new User();
        user.setUserId(33);
        like.setUser(user);
        Weibo weibo=new Weibo();
        weibo.setWeiboId(10);
        like.setWeibo(weibo);
        System.out.println(mapper.addLike(like));*/
        /*UserMapper mapper= (UserMapper) ctx.getBean("userMapper");
        for(int i=0;i<800;i++){
            User user=new User();
            user.setPassword("111111");
            user.setNickName("测试微博"+i+100);
            user.setAddress("北京市海淀区居山农场北京翰林职业学院");
            user.setBirthday(new Date());
            user.setHeadImg("default.jpg");
            user.setIntro("这是一个介绍这是一个介绍这是一个介绍");
            user.setSex(true);
            mapper.insert(user);
            System.out.println("插入一条用户："+i);
        }*/
        WeiboMapper mapper= (WeiboMapper) ctx.getBean("weiboMapper");
        for(int i=0;i<800;i++){
            Weibo weibo=new Weibo();
            weibo.setPics("577b8692-eeec-44ab-acf5-ca3996e6e9e0,9aa62a27-5fc8-4c12-93f1-377093493e0f,3cfc1412-93a1-48f3-96e7-ffc20ea5fb80,c5b48bd8-d52c-4e79-b828-e199f96ae201,18e00ba8-b624-4e2e-b57f-2cf61c0d822a,4b1bcda9-fb23-4c13-9944-f68cc123d5af,f35f11ce-a222-42cb-bdaa-24d1d3043f4e,ab171073-5df0-4b7f-8da7-06a079e2b959");
            weibo.setWeiboContent("<p>测试微博<img src=\"http://img.baidu.com/hi/face/i_f14.gif\"/>是打发打发</p>");
            weibo.setPublishTime(new Date());
            weibo.setIsRepost(false);
            User user=new User();
            user.setUserId(33);
            weibo.setUser(user);
            mapper.insert(weibo);
            System.out.println("插入一条微博");
        }
    }
}
