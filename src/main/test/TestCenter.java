
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
        UserMapper mapper= (UserMapper) ctx.getBean("userMapper");
        PageBean pageBean=new PageBean(50,1,0);
        List<User> list=mapper.searchUserByStr(pageBean,"测试");
        System.out.println(list);
    }
}
